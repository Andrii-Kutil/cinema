package com.gmail.kutilandrej.cinema.model.dto;

import javax.validation.constraints.Min;

public class CinemaHallRequestDto {
    @Min(100)
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
