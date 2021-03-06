package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.ShoppingCartDao;
import com.gmail.kutilandrej.cinema.dao.TicketDao;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private TicketDao ticketDao;

    @Override
    public void add(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket(movieSession, user);
        ticketDao.add(ticket);
        ShoppingCart cartByUser = getByUser(user);
        cartByUser.getTickets().add(ticket);
        shoppingCartDao.update(cartByUser);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void create(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
