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
    public List<Event> findEventsByVenueIdAndEventType(Integer venueId, String eventType) {
        if (eventType == null && venueId == null) {
            return eventRepository.findAll();
        }

        if (eventType == null) {
            return eventRepository.findEventsByVenue_Id(venueId);
        }

        if (venueId == null) {
            return eventRepository.findEventsByEventType_Name(eventType);
        }

        return eventRepository.findEventsByVenue_IdAndEventType_Name(venueId, eventType);
    }
}
