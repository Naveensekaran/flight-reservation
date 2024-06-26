package com.reservation.flight_reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFound extends RuntimeException{
    public TicketNotFound(String message){
        super(message);
    }
}
