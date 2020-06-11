package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    CinemaHall get(Long cinemaHallId);

    List<CinemaHall> getAll();
}
