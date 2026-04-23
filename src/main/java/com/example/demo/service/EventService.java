package com.example.demo.service;

import com.example.demo.dto.event.*;
import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.exception.ServiceException;
import com.example.demo.mapper.Mapper;
import com.example.demo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    public EventResponse createEvent(EventRequest event, User user) {
       if(eventRepository.existsByTitle(event.getTitle())) {
           throw new ServiceException("Title already exists");
       }

        eventRepository.save(Mapper.toEntity(event, user));
        return Mapper.toResponse(event);
    }

    public EventResponse updateEvent(Long id, EventRequest updatedEvent) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setLocation(updatedEvent.getLocation());
        event.setEventDate(updatedEvent.getEventDate());
        event.setAvailableTickets(updatedEvent.getAvailableTickets());

         eventRepository.save(event);
         return Mapper.toDTO(event);
    }

    public void deleteEvent(Long id) {
        if(!eventRepository.existsById(id)) {
            throw new ServiceException("Event not found");
        }
        eventRepository.deleteById(id);
    }
}