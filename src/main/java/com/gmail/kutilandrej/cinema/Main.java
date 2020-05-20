package com.gmail.kutilandrej.cinema;

import com.gmail.kutilandrej.cinema.lib.Injector;
import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.kutilandrej.cinema");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.getAll().forEach(System.out::println);
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
