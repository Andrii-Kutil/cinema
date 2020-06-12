package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    public CinemaHall add(CinemaHall cinemaHall);

    public List<CinemaHall> getAll();

    CinemaHall get(Long cinemaHallId);
}
