package com.example.project.bookmyshowbackend.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class ShowResponseDto {

    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieResponseDto movieResponseDto;
    private TheatreResponseDto theatreResponseDto;
}
