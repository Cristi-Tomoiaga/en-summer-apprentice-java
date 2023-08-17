package com.endava.ticketsjavabackend.mapstruct.dto;

import com.endava.ticketsjavabackend.model.Event;
import com.endava.ticketsjavabackend.model.TicketCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
