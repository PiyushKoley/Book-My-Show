package com.example.project.bookmyshowbackend.Service.ServiceImplementation;

import com.example.project.bookmyshowbackend.Models.*;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.ShowSeatsRepository;
import com.example.project.bookmyshowbackend.Repository.TheatreRepository;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.ShowService;
import com.example.project.bookmyshowbackend.converter.ShowConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        //in showConverter we just have made partial showEntity object from showDto..
        // bcz we have not created MovieEntity and TheatreEntity from MovieDto and TheatreDto inside ShowConverter...

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).orElse(null);

        TheatreEntity theatreEntity = theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).orElse(null);

        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        showEntity = showRepository.save(showEntity);

        generateShowSeatEntity(theatreEntity.getListOfSeat(), showEntity);


        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);
        return showResponseDto;

    }

    private void generateShowSeatEntity(List<TheatreSeatEntity> listOfTheatreSeatsEntity, ShowEntity showEntity) {

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        for(TheatreSeatEntity theatreSeatEntity : listOfTheatreSeatsEntity) {
            // for each seats in theatre we will create showSeatsEntity and save it in repo...

            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder()
                                                .seatNo(theatreSeatEntity.getSeatNo())
                                                .seatType(theatreSeatEntity.getSeatType())
                                                .rate(theatreSeatEntity.getRate())
                                                .show(showEntity)
                                                .build();

            showSeatsEntityList.add(showSeatsEntity);
        }




        showEntity.setListOfShowSeatsEntity(showSeatsEntityList);
        showSeatsRepository.saveAll(showSeatsEntityList);
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity = showRepository.findById(id).orElse(null);
        if(showEntity == null){
            return null;
        }
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);
        return showResponseDto;
    }
}
