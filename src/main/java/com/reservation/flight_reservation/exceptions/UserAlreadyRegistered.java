package com.reservation.flight_reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserAlreadyRegistered extends RuntimeException{
    public UserAlreadyRegistered(String message){
        super(message);
    }
}
