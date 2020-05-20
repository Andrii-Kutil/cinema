package com.gmail.kutilandrej.service.impl;

import com.gmail.kutilandrej.dao.MovieDao;
import com.gmail.kutilandrej.lib.Inject;
import com.gmail.kutilandrej.lib.Service;
import com.gmail.kutilandrej.model.Movie;
import com.gmail.kutilandrej.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Inject
    MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
