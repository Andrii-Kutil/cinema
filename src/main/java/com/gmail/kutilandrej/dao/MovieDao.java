package com.gmail.kutilandrej.dao;

import com.gmail.kutilandrej.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
