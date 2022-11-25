package com.example.project.bookmyshowbackend.Service.ServiceInterfaces;

import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id) throws Exception;

}
