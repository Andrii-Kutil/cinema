package com.gmail.kutilandrej.service;

import com.gmail.kutilandrej.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
