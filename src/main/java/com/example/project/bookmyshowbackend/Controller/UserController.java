package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Service.ServiceImplementation.UserServiceImpl;
import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> adduser(@RequestBody()UserEntryDto userEntryDto) {
        userService.addUser(userEntryDto);

        return new ResponseEntity<>("user added Success", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id) {

        UserResponseDto user = userService.getUser(id);
        if(user == null)
            return new ResponseEntity<>("user with given id not present",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
