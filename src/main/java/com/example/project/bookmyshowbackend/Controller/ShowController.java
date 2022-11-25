package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Service.ServiceImplementation.ShowServiceImpl;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.ShowService;
import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ResponseEntity<ShowResponseDto> addShow(@RequestBody() ShowEntryDto showEntryDto) {


        ShowResponseDto show =  showService.addShow(showEntryDto);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getShow(@PathVariable("id") int id) {
        ShowResponseDto show = showService.getShow(id);
        if(show == null){
            return new ResponseEntity<>("No show is there with given ID", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(show, HttpStatus.FOUND);
    }


}
