package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.enums.TheatreType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TheatreResponseDto {
    @NotNull
    private int id;

    private String name;
    private String address;
    private String city;
    private TheatreType type;
}
