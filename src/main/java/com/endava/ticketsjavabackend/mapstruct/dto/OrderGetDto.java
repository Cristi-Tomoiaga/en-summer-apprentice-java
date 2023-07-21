package com.endava.ticketsjavabackend.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class OrderGetDto {
    @JsonProperty("eventId")
    private int eventId;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("ticketCategoryId")
    private int ticketCategoryId;

    @JsonProperty("numberOfTickets")
    private int numberOfTickets;

    @JsonProperty("totalPrice")
    private double totalPrice;

    public OrderGetDto(int eventId, LocalDateTime timestamp, int ticketCategoryId, int numberOfTickets, double totalPrice) {
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.ticketCategoryId = ticketCategoryId;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public OrderGetDto() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
