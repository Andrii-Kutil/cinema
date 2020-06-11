package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.dto.OrderResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public List<OrderResponseDto> getOrderHistoryResponseDto(List<Order> orderHistory) {
        List<OrderResponseDto> orderHistoryResponseDto = new ArrayList<>();
        for (Order order: orderHistory) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setUserId(order.getId());
            orderResponseDto.setTicketsId(getListOfTicketsId(order.getTickets()));
            orderResponseDto.setLocalDateTime(order.getLocalDateTime());
            orderHistoryResponseDto.add(orderResponseDto);
        }
        return orderHistoryResponseDto;
    }

    private List<Long> getListOfTicketsId(List<Ticket> tickets) {
        List<Long> ticketsId = new ArrayList<>();
        for (Ticket ticket: tickets) {
            ticketsId.add(ticket.getId());
        }
        return ticketsId;
    }
}
