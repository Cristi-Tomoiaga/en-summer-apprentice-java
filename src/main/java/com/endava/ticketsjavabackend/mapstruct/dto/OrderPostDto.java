package com.endava.ticketsjavabackend.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderPostDto {
    @JsonProperty("eventId")
    private int eventId;

    @JsonProperty("ticketCategoryId")
    private int ticketCategoryId;

    @JsonProperty("numberOfTickets")
    private int numberOfTickets;

    public OrderPostDto(int eventId, int ticketCategoryId, int numberOfTickets) {
        this.eventId = eventId;
        this.ticketCategoryId = ticketCategoryId;
        this.numberOfTickets = numberOfTickets;
    }

    public OrderPostDto() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(int ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
