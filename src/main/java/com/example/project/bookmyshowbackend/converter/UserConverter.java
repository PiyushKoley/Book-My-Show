package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto) {
        return UserEntity.builder().name(userEntryDto.getName()).mobileNo(userEntryDto.getMobileNo()).build();
    }

    public static UserResponseDto convertEntityToDto(UserEntity userEntity) {
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).listOfBookedTickets(userEntity.getListOfTickets()).mobileNo(userEntity.getMobileNo()).build();
    }
}
