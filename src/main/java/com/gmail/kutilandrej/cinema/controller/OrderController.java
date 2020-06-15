package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.model.dto.OrderRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.OrderResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.OrderMapper;
import com.gmail.kutilandrej.cinema.service.OrderService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/complete")
    public void completeOrder(@RequestBody @Valid OrderRequestDto orderRequestDto) {
        User user = userService.get(orderRequestDto.getUserId());
        List<Ticket> tickets = shoppingCartService.getByUser(user).getTickets();
        orderService.completeOrder(tickets, user);
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistoryForUser(
            Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String email = principal.getUsername();
        User user = userService.findByEmail(email).get();
        List<Order> orderHistory = orderService.getOrderHistory(userService.get(user.getId()));
        return orderHistory
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
