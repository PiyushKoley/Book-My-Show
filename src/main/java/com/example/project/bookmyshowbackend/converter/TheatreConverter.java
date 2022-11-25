package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Models.TheatreEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.TheatreEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheatreResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theatreEntity){
        return TheatreResponseDto.builder()
                .id(theatreEntity.getId())
                .name(theatreEntity.getName())
                .address(theatreEntity.getAddress())
                .city(theatreEntity.getCity()).build();
    }

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreEntryeDto) {
        return TheatreEntity.builder()
                .name(theatreEntryeDto.getName())
                .address(theatreEntryeDto.getAddress())
                .city(theatreEntryeDto.getCity())
                .build();

        // should we write theatreDto.show
    }

}
