package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.User;
import java.util.List;

public interface OrderDao {

    Order add(Order order);

    List<Order> getByUser(User user);
}
