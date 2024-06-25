package com.reservation.flight_reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
    private String flightId;
    private String passengerFirstName;
    private String passengerMiddleName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String nameOnTheCard;
    private String cardNumber;

    private String expirationDate;
    private String securityCode;
}
