package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall getById(Long id);
}
