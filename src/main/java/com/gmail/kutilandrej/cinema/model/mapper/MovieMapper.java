package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.Movie;
import com.gmail.kutilandrej.cinema.model.dto.MovieRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie getMovieFromMovieRequestDto(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }

    public MovieResponseDto getMovieResponseDtoFromMovie(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }
}
