package com.example.demo.dto.ticket;

import com.example.demo.enums.TicketStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TicketResponse {
    private Integer quantity;

    private TicketStatus status;

    private String eventTitle;

    private String userName;
}