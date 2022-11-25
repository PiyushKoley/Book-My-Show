package com.example.project.bookmyshowbackend.dto.EntryRequest;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {

    String name;
    String address;
    String city;

}
