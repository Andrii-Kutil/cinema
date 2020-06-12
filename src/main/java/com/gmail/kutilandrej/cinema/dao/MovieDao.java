package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    Movie get(Long movieId);

    List<Movie> getAll();
}
