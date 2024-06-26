package com.reservation.flight_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends Abstractor {
    private String flightId;
    private String flightNumber;
    private String operationAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private LocalTime estimatedDepartureTime;
}
