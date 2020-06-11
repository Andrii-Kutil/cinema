package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.MovieSession;
import com.gmail.kutilandrej.cinema.model.dto.MovieSessionRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.MovieSessionResponseDto;
import com.gmail.kutilandrej.cinema.service.CinemaHallService;
import com.gmail.kutilandrej.cinema.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaHallService cinemaHallService;

    public MovieSession getMovieSessionFromMoviesSessionRequestDto(
            MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionDto.getShowTime());
        return movieSession;
    }

    public List<MovieSessionResponseDto> getAvailableSessionsResponseDto(
            List<MovieSession> availableSessions) {
        List<MovieSessionResponseDto> movieSessionResponseDto = new ArrayList<>();
        for (MovieSession movieSession : availableSessions) {
            movieSessionResponseDto.add(getMovieSessionResponseFromMovieSession(movieSession));
        }
        return movieSessionResponseDto;
    }

    private MovieSessionResponseDto getMovieSessionResponseFromMovieSession(
            MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setMovieSessionId(movieSession.getId());
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        return movieSessionResponseDto;
    }
}
