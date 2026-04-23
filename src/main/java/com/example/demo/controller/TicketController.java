package com.example.demo.controller;

import com.example.demo.dto.ticket.TicketRequest;
import com.example.demo.dto.ticket.TicketResponse;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.enums.TicketStatus;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TicketResponse> bookTicket(
            @AuthenticationPrincipal User user,
            @RequestBody TicketRequest ticketRequest
    ) {
        return ResponseEntity.ok(ticketService.bookTicket(user, ticketRequest));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<TicketStatus> changeStatus(@PathVariable Long id, @RequestBody TicketStatus status) {
        System.out.println(status);
        return ResponseEntity.ok(ticketService.approveTicket(id, status));
    }
}