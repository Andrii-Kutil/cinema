package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.ShoppingCart;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.model.dto.ShoppingCartRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.ShoppingCartResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.ShoppingCartMapper;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import com.gmail.kutilandrej.cinema.service.UserService;
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
@RequestMapping("/shopping-carts")
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private MovieSessionService movieSessionService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add-movie-session")
    public void addMovieSessionInCart(@RequestBody @Valid ShoppingCartRequestDto cartRequestDto) {
        MovieSession movieSession = movieSessionService.get(cartRequestDto.getSessionId());
        User user = userService.get(cartRequestDto.getUserId());
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUserId(
            Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String email = principal.getUsername();
        User user = userService.findByEmail(email).get();
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartMapper.getShoppingCartResponseDtoFromShoppingCart(shoppingCart);
    }
}
