package com.example.demo.dto.ticket;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {
    @NotNull
    private String title;

    @Min(1)
    @NotNull
    private Integer quantity;
}