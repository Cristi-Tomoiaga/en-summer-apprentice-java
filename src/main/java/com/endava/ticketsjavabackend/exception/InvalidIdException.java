package com.endava.ticketsjavabackend.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }

    public InvalidIdException(int entityId, String entityName) {
        super(String.format("Invalid id '%d' provided for entity '%s'.", entityId, entityName));
    }
}
