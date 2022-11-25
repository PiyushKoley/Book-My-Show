package com.example.project.bookmyshowbackend.Service.ServiceInterfaces;

import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    ShowResponseDto getShow(int id);
}
