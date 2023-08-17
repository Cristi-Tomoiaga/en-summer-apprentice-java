package com.endava.ticketsjavabackend.exception;

public class InvalidNumberOfTicketsException extends RuntimeException {
    public InvalidNumberOfTicketsException() {
    }

    public InvalidNumberOfTicketsException(String message) {
        super(message);
    }

    public InvalidNumberOfTicketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfTicketsException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberOfTicketsException(int numberOfTickets) {
        super(String.format("Invalid number of tickets '%d' provided.", numberOfTickets));
    }
}
