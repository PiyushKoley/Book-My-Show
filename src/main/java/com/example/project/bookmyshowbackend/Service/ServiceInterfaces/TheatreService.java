package com.example.project.bookmyshowbackend.Service.ServiceInterfaces;

import com.example.project.bookmyshowbackend.dto.EntryRequest.TheatreEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheatreResponseDto;

public interface TheatreService {

    void addTheatre(TheatreEntryDto theatreEntryDto);

    TheatreResponseDto getTheatre(int id);
}
