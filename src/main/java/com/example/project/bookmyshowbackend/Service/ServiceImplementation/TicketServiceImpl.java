package com.example.project.bookmyshowbackend.Service.ServiceImplementation;

import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.ShowSeatsEntity;
import com.example.project.bookmyshowbackend.Models.TicketEntity;
import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TicketRepository;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.TicketService;
import com.example.project.bookmyshowbackend.converter.TicketConverter;
import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;


import com.example.project.bookmyshowbackend.dto.ResponseDto.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        Set<String> requiredSeats = bookTicketRequestDto.getRequestedSeat();

        List<ShowSeatsEntity> listOfShowSeatsEntity = showEntity.getListOfShowSeatsEntity();


        //Option 1...
        List<ShowSeatsEntity> bookedSeats = listOfShowSeatsEntity.stream()
                                            .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
                                                    &&  !seat.isBooked()
                                                    && requiredSeats.contains(seat.getSeatNo()))
                                            .collect(Collectors.toList());


        //Option 2...
//        List<ShowSeatsEntity> bookedSeats1 = new ArrayList<>();
//
//        for(ShowSeatsEntity seat : listOfShowSeatsEntity) {
//            if(!seat.isBooked() && requiredSeats.contains(seat.getSeatNo()) && seat.getSeatType().equals(bookTicketRequestDto.getSeatType())) {
//                bookedSeats1.add(seat);
//            }
//
//        }


        if(bookedSeats.size() != requiredSeats.size()) {
            // all required seats are not available

            throw new Error("All required seats are not available");
        }

        //Step 2...
        TicketEntity ticketEntity = TicketEntity.builder()
                                    .user(userEntity)
                                    .listOfBookedSeats(bookedSeats)
                                    .build();

        //Step 3...

        int amount = 0;
        for(ShowSeatsEntity showSeatsEntity : bookedSeats) {
            showSeatsEntity.setTicket(ticketEntity);
            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());

            amount += showSeatsEntity.getRate();
        }

        ticketEntity.setShow(showEntity);
        ticketEntity.setAmount(amount);
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));


        // connect in the show and
        // showEntity.setTicket()
        showEntity.getListOfTickets().add(ticketEntity);


        // userEntity.setTicket()..
        userEntity.getListOfTickets().add(ticketEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(ticketEntity);
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        return TicketConverter.convertEntityToDto(ticketEntity);
    }

    private String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNo()+" ";
        }

        return str;

    }
}
