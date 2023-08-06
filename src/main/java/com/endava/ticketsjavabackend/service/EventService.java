package com.endava.ticketsjavabackend.service;

import com.endava.ticketsjavabackend.model.Event;

import java.util.List;

public interface EventService {
    List<Event> findEventsByVenueLocationAndEventType(String venueLocation, String eventType);
}
