package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto getUserResponseDtoFromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
