package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.CinemaHallDao;
import com.gmail.kutilandrej.cinema.lib.Inject;
import com.gmail.kutilandrej.cinema.lib.Service;
import com.gmail.kutilandrej.cinema.model.CinemaHall;
import com.gmail.kutilandrej.cinema.service.CinemaHallService;
import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
