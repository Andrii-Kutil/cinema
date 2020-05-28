package com.gmail.kutilandrej.cinema;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.lib.Injector;
import com.gmail.kutilandrej.cinema.model.CinemaHall;
import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.Order;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import com.gmail.kutilandrej.cinema.service.OrderService;
import com.gmail.kutilandrej.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.kutilandrej.cinema");

    public static void main(String[] args) throws AuthenticationException {
        Movie movie1 = new Movie("Fast", "18+");
        Movie movie2 = new Movie("Low", "3+");
        CinemaHall cinemaHall1 = new CinemaHall(500, "Red");
        CinemaHall cinemaHall2 = new CinemaHall(700, "Blue");

        MovieSession movieSession1 = new MovieSession(movie1, cinemaHall1,
                LocalDateTime.of(2020, Month.JULY, 29, 19, 30));
        MovieSession movieSession2 = new MovieSession(movie1, cinemaHall2,
                LocalDateTime.of(2020, Month.JULY, 29, 10, 45));
        MovieSession movieSession3 = new MovieSession(movie2, cinemaHall1,
                LocalDateTime.of(2020, Month.AUGUST, 1, 11, 0));
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession1);
        movieSessionService.add(movieSession2);
        movieSessionService.add(movieSession3);

        AuthenticationService authenticationService = (AuthenticationService)
                injector.getInstance(AuthenticationService.class);
        authenticationService.register("a", "kutil", "1234");
        User user = authenticationService.login("a", "1234");

        ShoppingCartService shoppingCartService = (ShoppingCartService)
                injector.getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(movieSession1, user);
        OrderService orderService = (OrderService)
                injector.getInstance(OrderService.class);
        orderService.completeOrder(shoppingCartService.getByUser(user).getTickets(), user);
        System.out.println("---------------------------------------");
        List<Order> orderHistory = orderService.getOrderHistory(user);
        orderHistory.forEach(System.out::println);
    }
}
