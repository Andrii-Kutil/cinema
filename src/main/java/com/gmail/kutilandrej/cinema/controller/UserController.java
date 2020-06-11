package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.model.dto.UserResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.UserMapper;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/by-email")
    public UserResponseDto findByEmail(@RequestParam(name = "email") String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(u -> userMapper.getUserResponseDtoFromUser(u)).orElseThrow();
    }
}
