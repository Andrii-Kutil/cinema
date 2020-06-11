package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.model.dto.MovieRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.MovieResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public List<MovieResponseDto> allMoviesResponseDto(List<Movie> allMovies) {
        List<MovieResponseDto> allMoviesResponseDto = new ArrayList<>();
        for (Movie movie : allMovies) {
            allMoviesResponseDto.add(getMovieResponseDtoFromMovie(movie));
        }
        return allMoviesResponseDto;
    }

    public Movie getMovieFromMovieRequestDto(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }

    private MovieResponseDto getMovieResponseDtoFromMovie(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }
}
