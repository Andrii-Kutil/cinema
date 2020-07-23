package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.dto.MovieSessionRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.MovieSessionResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.MovieSessionMapper;
import com.gmail.kutilandrej.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {

    @Autowired
    private MovieSessionService movieSessionService;

    @Autowired
    private MovieSessionMapper movieSessionMapper;

    @PostMapping
    public void add(@RequestBody @Valid MovieSessionRequestDto movieSessionDto) {
        movieSessionService.add(movieSessionMapper
                .getMovieSessionFromMoviesSessionRequestDto(movieSessionDto));

    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getByDate(
            @RequestParam("movieId") Long movieId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<MovieSession> availableSessions = movieSessionService
                .getByDate(movieId, date);
        return availableSessions.stream()
                .map(movieSessionMapper::getMovieSessionResponseFromMovieSession)
                .collect(Collectors.toList());
    }
}
