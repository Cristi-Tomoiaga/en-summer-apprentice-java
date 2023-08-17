package com.endava.ticketsjavabackend.exception.handler;

import com.endava.ticketsjavabackend.exception.InvalidIdException;
import com.endava.ticketsjavabackend.exception.InvalidNumberOfTicketsException;
import com.endava.ticketsjavabackend.exception.InvalidTicketCategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ApiErrorResponse handleInvalidIdException(RuntimeException ex) {
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(InvalidNumberOfTicketsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ApiErrorResponse handleInvalidNumberOfTicketsException(RuntimeException ex) {
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(InvalidTicketCategoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ApiErrorResponse handleInvalidTicketCategoryException(RuntimeException ex) {
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ApiErrorResponse handleException() {
        return new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
