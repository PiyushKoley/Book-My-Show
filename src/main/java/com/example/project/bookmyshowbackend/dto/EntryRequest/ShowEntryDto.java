package com.example.project.bookmyshowbackend.dto.EntryRequest;

import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {
    @NotNull
    private LocalDate showDate;

    @NotNull
    private LocalTime showTime;

    @NotNull
    private MovieResponseDto movieResponseDto;

    @NotNull
    private TheatreResponseDto theatreResponseDto;
}
