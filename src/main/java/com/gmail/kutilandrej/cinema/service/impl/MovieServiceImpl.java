package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.MovieDao;
import com.gmail.kutilandrej.cinema.lib.Inject;
import com.gmail.kutilandrej.cinema.lib.Service;
import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Inject
   private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
