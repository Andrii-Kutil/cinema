package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.dto.CinemaHallRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.CinemaHallResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.CinemaHallMapper;
import com.gmail.kutilandrej.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @Autowired
    private CinemaHallMapper cinemaHallMapper;

    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallDto) {
        cinemaHallService.add(cinemaHallMapper
                .getCinemaHallFromCinemaHallRequestDto(cinemaHallDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::getCinemaHallResponseDtoFromCinemaHall)
                .collect(Collectors.toList());
    }
}
