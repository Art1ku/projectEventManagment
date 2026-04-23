package com.example.demo.dto.event;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    @Future
    private LocalDate eventDate;

    @Min(1)
    private Integer availableTickets;
}