package com.endava.ticketsjavabackend.controller;

import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventServiceImpl) {
        this.eventService = eventServiceImpl;
    }

    @GetMapping
    public List<Event> getAllByVenueIdAndEventType(@RequestParam(name = "venueId", required = false) Integer venueId,
                                                   @RequestParam(name = "eventType", required = false) String eventType) {
        return eventService.findEventsByVenueIdAndEventType(venueId, eventType);
    }
}
