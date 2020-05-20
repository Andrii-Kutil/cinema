package com.gmail.kutilandrej;

import com.gmail.kutilandrej.lib.Injector;
import com.gmail.kutilandrej.model.Movie;
import com.gmail.kutilandrej.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.kutilandrej");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.getAll().forEach(System.out::println);
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
