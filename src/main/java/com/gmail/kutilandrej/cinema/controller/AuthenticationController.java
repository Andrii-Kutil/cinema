package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.dto.UserRequestDto;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userDto) throws AuthenticationException {
        authenticationService.register(userDto.getEmail(),
                userDto.getLogin(), userDto.getPassword());
    }
}
