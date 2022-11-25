package com.example.project.bookmyshowbackend.converter;


import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieNameAndIdObject;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto) {

        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {

        return MovieResponseDto.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate())
                .build();
    }

    public static MovieNameAndIdObject convertEntityToObject(MovieEntity movieEntity) {

        return MovieNameAndIdObject.builder()
                .name(movieEntity.getName())
                .id(movieEntity.getId())
                .build();
    }
}
