package com.example.project.bookmyshowbackend.dto;

import com.example.project.bookmyshowbackend.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    private int userId;

    private int showId;

    private SeatType seatType;

    private Set<String> requestedSeat;
}
