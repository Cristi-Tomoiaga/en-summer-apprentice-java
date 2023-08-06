package com.endava.ticketsjavabackend.mapstruct.dto;

import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.model.TicketCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class OrderGetDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("event")
    private Event event;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("ticketCategory")
    private TicketCategory ticketCategory;

    @JsonProperty("numberOfTickets")
    private int numberOfTickets;

    @JsonProperty("totalPrice")
    private double totalPrice;

    public OrderGetDto(int id, Event event, LocalDateTime timestamp, TicketCategory ticketCategory, int numberOfTickets, double totalPrice) {
        this.id = id;
        this.event = event;
        this.timestamp = timestamp;
        this.ticketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public OrderGetDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
