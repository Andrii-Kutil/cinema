package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long movieId);

    List<Movie> getAll();
}
