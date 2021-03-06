package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.model.Role;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.RoleService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Override
    public User registration(String email, String login, String password) {
        User user = new User(login, email);
        user.setPassword(passwordEncoder.encode(password));
        Role roleUser = roleService.getByName("USER");
        user.setRoles(Set.of(roleUser));
        userService.add(user);
        shoppingCartService.create(user);
        return user;
    }
}
