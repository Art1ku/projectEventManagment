package com.example.demo.service;

import com.example.demo.dto.ticket.*;
import com.example.demo.entity.*;
import com.example.demo.enums.TicketStatus;
import com.example.demo.exception.ServiceException;
import com.example.demo.mapper.Mapper;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    @Transactional
    public TicketResponse bookTicket(User user, TicketRequest ticketRequest) {
        Event event = eventRepository.findByTitle(ticketRequest.getTitle())
                .orElseThrow(() -> new ServiceException("Event not found"));

        if (event.getAvailableTickets() < ticketRequest.getQuantity()) {
            throw new ServiceException("Not enough tickets! Available: " + event.getAvailableTickets());
        }

        event.setAvailableTickets(event.getAvailableTickets() - ticketRequest.getQuantity());
        eventRepository.save(event);

        Ticket ticket = Mapper.toEntity(ticketRequest, event, user);
        Ticket savedTicket = ticketRepository.save(ticket);

        return Mapper.toTicketDTO(savedTicket);
    }

    public TicketStatus approveTicket(Long ticketId, TicketStatus status) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ServiceException("Ticket not found"));

        ticket.setStatus(status);

        ticketRepository.save(ticket);

        return ticket.getStatus();
    }
}