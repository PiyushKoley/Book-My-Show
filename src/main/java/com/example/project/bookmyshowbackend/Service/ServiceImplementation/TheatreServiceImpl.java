package com.example.project.bookmyshowbackend.Service.ServiceImplementation;

import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.Models.TheatreSeatEntity;
import com.example.project.bookmyshowbackend.Repository.TheatreRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreSeatRepository;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.TheatreService;
import com.example.project.bookmyshowbackend.converter.TheatreConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.TheatreEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheatreResponseDto;
import com.example.project.bookmyshowbackend.enums.SeatType;
import com.example.project.bookmyshowbackend.enums.TheatreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public void addTheatre(TheatreEntryDto theatreEntryDto) {
        // we have to write addSeats in this..
        // we need a theatreEntity..

        TheatreEntity theatreEntity = TheatreConverter.convertDtoToEntity(theatreEntryDto);

        // create the seats...
        List<TheatreSeatEntity> seats = createTheatreSeats();

        // **********************    IMPORTANT     **************************
        // you can see that we have saved seats to SeatRepository before,,, without setting theatreEntity for each seats..
        // so initially inside seat_repo theatre_Entity = NULL; for all seats, and later we set theatreEntity for each seats in below forEach loop...
        // then how theatreEntity get saved for each seats in seatRepo ??????...
        //
        // THIS GETS SAVED BECAUSE OF BILATERAL MAPPING (in parent class i.e. TheatreEntity we write cascade = CascadeType.ALL)
        // for theatreSeatsEntity..
        // SO WHEN WE SAVE THEATRE_ENTITY TO THEATRE_REPOSITORY THEN IN SEAT_REPO ALSO THEATRE GETS SAVED FOR EVERY SEATS...
        //====================================================================================================================

        theatreEntity.setListOfSeat(seats);

        for(TheatreSeatEntity seat : seats) {
            seat.setTheatre(theatreEntity);
        }
        theatreEntity.setType(TheatreType.SINGLE);
        theatreRepository.save(theatreEntity);
    }

    private List<TheatreSeatEntity> createTheatreSeats() {

        List<TheatreSeatEntity> seats = new ArrayList<>();

        seats.add(getTheatreSeat("1A",100,SeatType.CLASSIC)); //add TheatreSeatsEntity in this..
        seats.add(getTheatreSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheatreSeat("2A",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2B",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2C",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2D",200,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2E",200,SeatType.PREMIUM));

        theatreSeatRepository.saveAll(seats);

        return seats;
    }

    // creating theatreSeat in this;
    private TheatreSeatEntity getTheatreSeat(String seatNo, int rate, SeatType seatType) {
        return TheatreSeatEntity.builder().seatNo(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {

        TheatreEntity theatreEntity = theatreRepository.findById(id).get();

        TheatreResponseDto theatreResponseDto = TheatreConverter.convertEntityToDto(theatreEntity);

        return theatreResponseDto;
    }
}
