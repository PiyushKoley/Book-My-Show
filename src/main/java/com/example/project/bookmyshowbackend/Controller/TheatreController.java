package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Service.ServiceImplementation.TheatreServiceImpl;
import com.example.project.bookmyshowbackend.dto.EntryRequest.TheatreEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody() TheatreEntryDto theatreEntryDto){
        theatreService.addTheatre(theatreEntryDto);
        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }

}
