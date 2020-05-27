package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
