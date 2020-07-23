package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(List<Ticket> tickets, User user);

    List<Order> getByUser(User user);
}
