package com.endava.ticketsjavabackend.exception;

public class UnavailableSeatsException extends RuntimeException {
    public UnavailableSeatsException() {
    }

    public UnavailableSeatsException(String message) {
        super(message);
    }

    public UnavailableSeatsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableSeatsException(Throwable cause) {
        super(cause);
    }

    public UnavailableSeatsException(int numberOfTickets, int availableSeats, int eventId) {
        super(String.format("Unavailable number of tickets for Event with the id '%d': requested '%d' tickets, available '%d' seats.",
                eventId, numberOfTickets, availableSeats));
    }
}
