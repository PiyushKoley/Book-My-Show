package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Service.ServiceImplementation.MovieServiceImpl;
import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody() MovieEntryDto movieEntryDto) {
        MovieResponseDto movie = movieService.addMovie(movieEntryDto);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getMovie(@PathVariable("id") int id) {

        MovieResponseDto movie = movieService.getMovie(id);

        return new ResponseEntity(movie, HttpStatus.FOUND);
    }
}
