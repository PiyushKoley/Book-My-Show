package com.example.project.bookmyshowbackend.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieNameAndIdObject {

    private int id;

    private String name;

}
