package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.dto.UserRegistrationDto;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/registration")
    public void registration(@RequestBody @Valid UserRegistrationDto userDto)
            throws AuthenticationException {
        authenticationService.registration(userDto.getEmail(),
                userDto.getLogin(), userDto.getPassword());
    }
}
