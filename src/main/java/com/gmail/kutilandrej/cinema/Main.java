package com.gmail.kutilandrej.cinema;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.lib.Injector;
import com.gmail.kutilandrej.cinema.model.CinemaHall;
import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.AuthenticationService;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import com.gmail.kutilandrej.cinema.service.UserService;
import com.gmail.kutilandrej.cinema.util.HashUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

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
        System.out.println(movieSessionService
                .findAvailableSessions(1L, LocalDate.of(2020, Month.JULY, 29)));

        User user1 = new User("kutil", "kutilandej@gmail.com");
        user1.setSalt(HashUtil.getSalt());
        user1.setPassword(HashUtil.hashPassword("1234", user1.getSalt()));
        User user2 = new User("bob", "1@gmail.com");
        UserService userService = (UserService) injector.getInstance(UserService.class);
        userService.add(user1);
        userService.add(user2);
        System.out.println("Find user with email - 1@gmail.com: "
                + userService.findByEmail("1@gmail.com").get());

        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);
        System.out.println("Check email and password: "
                + authenticationService.login("kutilandej@gmail.com", "1234"));
        System.out.println("Registrate bOb: " + authenticationService
                .register("bob@gmail.com", "bOb", "1234"));
    }
}
