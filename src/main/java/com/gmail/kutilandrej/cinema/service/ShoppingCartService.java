package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);
}
