package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.User;

public interface ShoppingCartService {
    void add(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void create(User user);

    void clear(ShoppingCart shoppingCart);
}
