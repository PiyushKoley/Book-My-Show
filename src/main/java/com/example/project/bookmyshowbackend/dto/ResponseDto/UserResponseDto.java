package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserResponseDto {

    private int id;
    private String name;
    private String mobileNo;
    //Optional
    private List<TicketDto> listOfBookedTickets;
}
