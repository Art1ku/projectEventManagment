package com.example.demo.mapper;

import com.example.demo.dto.event.EventRequest;
import com.example.demo.dto.event.EventResponse;
import com.example.demo.dto.ticket.TicketRequest;
import com.example.demo.dto.ticket.TicketResponse;
import com.example.demo.entity.Event;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.enums.TicketStatus;

public class Mapper {

    public static EventResponse toDTO(Event event) {
        return EventResponse.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .eventDate(event.getEventDate())
                .availableTickets(event.getAvailableTickets())
                .build();
    }

    public static EventResponse toResponse(EventRequest event) {
        return EventResponse.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .eventDate(event.getEventDate())
                .availableTickets(event.getAvailableTickets())
                .build();
    }

    public static Event toEntity(EventRequest request, User user) {
        return Event.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .eventDate(request.getEventDate())
                .availableTickets(request.getAvailableTickets())
                .createdBy(user)
                .build();
    }

    public static Ticket toEntity(TicketRequest request, Event event, User user) {
        return Ticket.builder()
                .quantity(request.getQuantity())
                .status(TicketStatus.PENDING) // Статус по умолчанию
                .event(event)
                .user(user)
                .build();
    }

    public static TicketResponse toTicketDTO(Ticket ticket) {
        return TicketResponse.builder()
                .quantity(ticket.getQuantity())
                .status(ticket.getStatus())
                .eventTitle(ticket.getEvent().getTitle())
                .userName(ticket.getUser().getName())
                .build();
    }
}
