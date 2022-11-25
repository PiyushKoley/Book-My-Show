package com.example.project.bookmyshowbackend.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {

    private int id;

    private String allottedSeats;
    private int amount;

}
