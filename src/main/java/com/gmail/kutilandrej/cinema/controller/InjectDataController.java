package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.Role;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.RoleService;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void insertRolesToDb() {
        Role roleAdmin = roleService.add(Role.of("ADMIN"));
        Role roleUser = roleService.add(Role.of("USER"));
        User admin = new User("admin", "admin@i.ua", "1234", Set.of(roleAdmin));
        User user = new User("kutil", "kutil@i.ua", "1234", Set.of(roleUser));
        userService.add(admin);
        userService.add(user);
    }
}
