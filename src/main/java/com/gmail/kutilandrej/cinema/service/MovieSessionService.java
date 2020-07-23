package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> getByDate(Long id, LocalDate date);

    MovieSession add(MovieSession movieSession);

    MovieSession getById(Long id);
}
