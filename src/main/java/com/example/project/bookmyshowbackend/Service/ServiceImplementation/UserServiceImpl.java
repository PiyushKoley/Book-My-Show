package com.example.project.bookmyshowbackend.Service.ServiceImplementation;

import com.example.project.bookmyshowbackend.Models.UserEntity;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.Service.ServiceInterfaces.UserService;
import com.example.project.bookmyshowbackend.converter.UserConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        //we will save userEntity inside userRepository....  so we need to convert Dto to Entity...
        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {

        // since i need to return user...first i have to get user from userRepo (i.e. DB)..
        // but inside DB user may be present or may not .....
        // so we have to write Optional<UserEntity> userEntity = userRepository.findById(id);
        // UserDto userDto = UserConverter.convertEntityToDto(userEntity.get());
        //    ....OR....
        // we can just write UserEntity userEntity = userRepository.findById(id).get();
        // or userRepository.findById(id).orElse(null or any other object ,if not found object with given id);
        // means if user is not present in DB then we should return null or some other object..

        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null)
            return null;

        //since i need to return UserDto so we have to convert userEntity to userDto....
        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;
    }

}
