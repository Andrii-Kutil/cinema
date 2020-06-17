package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import com.gmail.kutilandrej.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        return userService.findByEmail(email).filter(u -> u.getPassword()
                .equals(password))
                .orElseThrow(() -> new AuthenticationException("Incorrect email or password!"));
    }

    @Override
    public User register(String email, String login, String password) {
        User user = new User(login, email);
        user.setPassword(password);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
