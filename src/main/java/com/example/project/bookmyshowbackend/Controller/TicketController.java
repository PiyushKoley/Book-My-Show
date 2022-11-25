package com.example.project.bookmyshowbackend.Controller;

import com.example.project.bookmyshowbackend.Service.ServiceImplementation.TicketServiceImpl;
import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public ResponseEntity addTicket(@RequestBody()BookTicketRequestDto bookTicketRequestDto) {

        return new ResponseEntity(ticketService.bookTicket(bookTicketRequestDto) , HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTicketById(@PathVariable("id") int id) {

        return new ResponseEntity(ticketService.getTicket(id), HttpStatus.OK);
    }
}
