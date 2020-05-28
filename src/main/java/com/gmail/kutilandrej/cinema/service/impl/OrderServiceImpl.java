package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.OrderDao;
import com.gmail.kutilandrej.cinema.lib.Inject;
import com.gmail.kutilandrej.cinema.lib.Service;
import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.OrderService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderDao orderDao;

    @Inject
    ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(List<Ticket> tickets, User user) {
        Order order = orderDao.add(new Order(tickets, user, LocalDateTime.now()));
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
