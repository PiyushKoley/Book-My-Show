package com.example.project.bookmyshowbackend.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<ShowResponseDto> listOfShowDto;
}
