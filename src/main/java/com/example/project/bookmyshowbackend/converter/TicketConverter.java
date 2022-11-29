package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Models.TicketEntity;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TicketResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity) {
        return TicketResponseDto.builder()
                .id(ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .allottedSeats(ticketEntity.getAllottedSeats())
                .listOfBookedSeats(ticketEntity.getListOfBookedSeats())
                .build();
    }
}
