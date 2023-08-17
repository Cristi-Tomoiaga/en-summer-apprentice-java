package com.endava.ticketsjavabackend.exception;

public class InvalidTicketCategoryException extends RuntimeException {
    public InvalidTicketCategoryException() {
    }

    public InvalidTicketCategoryException(String message) {
        super(message);
    }

    public InvalidTicketCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTicketCategoryException(Throwable cause) {
        super(cause);
    }

    public InvalidTicketCategoryException(int ticketCategoryId, int eventId) {
        super(String.format("The TicketCategory with id '%d' is not available for the Event with id '%d'.",
                        ticketCategoryId, eventId));
    }
}
