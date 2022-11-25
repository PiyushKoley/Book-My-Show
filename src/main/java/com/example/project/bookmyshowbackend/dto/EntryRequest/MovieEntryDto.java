package com.example.project.bookmyshowbackend.dto.EntryRequest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
public class MovieEntryDto {

    private String name;
    private LocalDate releaseDate;

}
