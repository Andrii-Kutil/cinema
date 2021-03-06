package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.MovieSessionDao;
import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {

    @Autowired
    MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> getByDate(Long id, LocalDate date) {
        return movieSessionDao.getByDate(id, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public MovieSession getById(Long id) {
        return movieSessionDao.getById(id);
    }
}
