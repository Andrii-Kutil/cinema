package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.Role;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.RoleService;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationService authenticationService;

    @PostConstruct
    public void insertRolesToDb() throws AuthenticationException {
        Role roleAdmin = roleService.add(Role.of("ADMIN"));
        roleService.add(Role.of("USER"));
        User admin = new User("admin", "admin@i.ua",
                passwordEncoder.encode("1234"), Set.of(roleAdmin));
        userService.add(admin);
        authenticationService.register("user@i.ua", "user", "1234");
    }
}
