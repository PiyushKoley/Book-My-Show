package com.example.project.bookmyshowbackend.Service.ServiceImplementation;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.MovieService;
import com.example.project.bookmyshowbackend.converter.MovieConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieNameAndIdObject;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        // if movie is already present in DB then don't add it agian in DB..
        // how to achieve this ...
        MovieResponseDto movieResponseDto = null;

        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("this name is already exist in movies list...");
            return movieResponseDto;
        }


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);

        //[ (movieEntity = ) ]************* IMPORTANT **************
        movieEntity = movieRepository.save(movieEntity);  // THIS WILL AUTOMATICALLY add ID VARIABLE IN movieEntity variable here..

        movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);



        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id)  {
        MovieEntity movieEntity = movieRepository.findById(id).orElse(null);
        if(movieEntity == null){
            throw new Error("Movie does not exist");
        }
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto;
    }

    public MovieNameAndIdObject getNameAndId(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieNameAndIdObject obj = MovieConverter.convertEntityToObject(movieEntity);

        return obj;
    }
}
