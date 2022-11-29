package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.Models.ShowSeatsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TicketResponseDto {

    private int id;

    private String allottedSeats;
    private int amount;
    private List<ShowSeatsEntity> listOfBookedSeats;

}
