package com.example.project.bookmyshowbackend.dto;

import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    private int id;
    private String alloted_seats;

    private double amount;

    private ShowResponseDto showDto;

    @NotNull
    UserResponseDto userResponseDto; //Mandatory for me to fill this userDto Value


}
