package com.endava.ticketsjavabackend.controller;

import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventServiceImpl) {
        this.eventService = eventServiceImpl;
    }

    @GetMapping
    public List<Event> getAllByVenueLocationAndEventType(@RequestParam(name = "venueLocation", required = false) String venueLocation,
                                                   @RequestParam(name = "eventType", required = false) String eventType) {
        return eventService.findEventsByVenueLocationAndEventType(venueLocation, eventType);
    }
}
