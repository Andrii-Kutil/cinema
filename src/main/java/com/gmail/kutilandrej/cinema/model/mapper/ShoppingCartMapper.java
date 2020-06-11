package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.Ticket;
import com.gmail.kutilandrej.cinema.model.dto.ShoppingCartResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {

    public ShoppingCartResponseDto getShoppingCartResponseDtoFromShoppingCart(
            ShoppingCart shoppingCart) {
        ShoppingCartResponseDto cartResponseDto = new ShoppingCartResponseDto();
        cartResponseDto.setId(shoppingCart.getId());
        cartResponseDto.setUserLogin(shoppingCart.getUser().getLogin());
        cartResponseDto.setTicketsId(getListTicketsId(shoppingCart.getTickets()));
        return cartResponseDto;
    }

    private List<Long> getListTicketsId(List<Ticket> tickets) {
        List<Long> ticketsId = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketsId.add(ticket.getId());
        }
        return ticketsId;
    }
}
