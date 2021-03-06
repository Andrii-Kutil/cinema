package com.gmail.kutilandrej.cinema.controller;

import com.gmail.kutilandrej.cinema.model.dto.MovieRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.MovieResponseDto;
import com.gmail.kutilandrej.cinema.model.mapper.MovieMapper;
import com.gmail.kutilandrej.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @PostMapping
    public void add(@RequestBody @Valid MovieRequestDto movieDto) {
        movieService.add(movieMapper.getMovieFromMovieRequestDto(movieDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::getMovieResponseDtoFromMovie)
                .collect(Collectors.toList());
    }
}
