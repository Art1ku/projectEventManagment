package com.example.demo.dto.event;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EventResponse {

    private String title;

    private String description;

    private String location;

    private LocalDate eventDate;

    private Integer availableTickets;
}