package com.endava.ticketsjavabackend.service;

import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findEventsByVenueLocationAndEventType(String venueLocation, String eventType) {
        if (eventType == null && venueLocation == null) {
            return eventRepository.findAll();
        }

        if (eventType == null) {
            return eventRepository.findEventsByVenue_LocationContaining(venueLocation.trim());
        }

        if (venueLocation == null) {
            return eventRepository.findEventsByEventType_NameContaining(eventType.trim());
        }

        return eventRepository.findEventsByVenue_LocationContainingAndEventType_NameContaining(venueLocation.trim(), eventType.trim());
    }
}
