package com.gmail.kutilandrej.cinema;

import com.gmail.kutilandrej.cinema.lib.Injector;
import com.gmail.kutilandrej.cinema.model.CinemaHall;
import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.service.CinemaHallService;
import com.gmail.kutilandrej.cinema.service.MovieService;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.kutilandrej.cinema");

    public static void main(String[] args) {
        Movie movie1 = new Movie("Fast", "18+");
        Movie movie2 = new Movie("Low", "3+");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        movieService.add(movie1);
        movieService.add(movie2);

        CinemaHall cinemaHall1 = new CinemaHall(500, "Red");
        CinemaHall cinemaHall2 = new CinemaHall(700, "Blue");
        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall1);
        cinemaHallService.add(cinemaHall2);

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
    }
}
