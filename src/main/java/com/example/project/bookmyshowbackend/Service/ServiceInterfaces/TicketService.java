package com.example.project.bookmyshowbackend.Service.ServiceInterfaces;

import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TicketResponseDto;

public interface TicketService {
     //bookticket
    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    //getTicket
    TicketResponseDto getTicket(int id);

}
