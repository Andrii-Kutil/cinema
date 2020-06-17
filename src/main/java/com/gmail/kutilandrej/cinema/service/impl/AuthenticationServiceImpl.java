package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.Role;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.RoleService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Override
    public User register(String email, String login, String password) {
        User user = new User(login, email);
        user.setPassword(password);
        Role roleUser = roleService.getRoleByName("USER");
        user.setRoles(Set.of(roleUser));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
