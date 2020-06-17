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
        Role r1 = roleService.add(Role.of("ADMIN"));
        Role r2 = roleService.add(Role.of("USER"));
        User user2 = new User("admin", "admin@i.ua", "1234", Set.of(r1));
        User user1 = new User("kutil", "kutil@i.ua", "1234", Set.of(r2));
        userService.add(user1);
        userService.add(user2);
    }
}
