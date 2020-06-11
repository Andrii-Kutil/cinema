package com.gmail.kutilandrej.cinema.model.mapper;

import com.gmail.kutilandrej.cinema.model.CinemaHall;
import com.gmail.kutilandrej.cinema.model.dto.CinemaHallRequestDto;
import com.gmail.kutilandrej.cinema.model.dto.CinemaHallResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {

    public CinemaHall getCinemaHallFromCinemaHallRequestDto(
            CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallRequestDto.getCapacity());
        cinemaHall.setDescription(cinemaHallRequestDto.getDescription());
        return cinemaHall;
    }

    public List<CinemaHallResponseDto> allCinemaHallsResponseDto(List<CinemaHall> allCinemaHalls) {
        List<CinemaHallResponseDto> allCinemaHallsResponseDto = new ArrayList<>();
        for (CinemaHall cinemaHall : allCinemaHalls) {
            allCinemaHallsResponseDto.add(getCinemaHallResponseDtoFromCinemaHall(cinemaHall));
        }
        return allCinemaHallsResponseDto;
    }

    private CinemaHallResponseDto getCinemaHallResponseDtoFromCinemaHall(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setCinemaHallId(cinemaHall.getId());
        cinemaHallResponseDto.setDescription(cinemaHall.getDescription());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponseDto;
    }
}
