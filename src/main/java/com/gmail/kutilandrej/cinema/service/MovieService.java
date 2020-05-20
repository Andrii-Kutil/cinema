package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
