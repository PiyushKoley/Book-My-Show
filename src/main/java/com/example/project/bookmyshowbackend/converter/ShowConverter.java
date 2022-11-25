package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Models.ShowEntity;
import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheatreResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity) {

        MovieEntity movieEntity = showEntity.getMovie();
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        TheatreEntity theatreEntity = showEntity.getTheatre();
        TheatreResponseDto theatreResponseDto = TheatreConverter.convertEntityToDto(theatreEntity);


        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .movieResponseDto(movieResponseDto)
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .theatreResponseDto(theatreResponseDto)
                .build();
    }

    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto) {
        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime()).build();
    }
}
