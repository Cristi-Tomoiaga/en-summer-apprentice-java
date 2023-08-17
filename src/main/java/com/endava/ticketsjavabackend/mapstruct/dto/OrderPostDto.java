package com.endava.ticketsjavabackend.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPostDto {
    @JsonProperty("eventId")
    private int eventId;

    @JsonProperty("ticketCategoryId")
    private int ticketCategoryId;

    @JsonProperty("numberOfTickets")
    private int numberOfTickets;
}
