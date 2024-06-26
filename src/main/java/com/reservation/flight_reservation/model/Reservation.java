package com.reservation.flight_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation extends Abstractor {
    private Boolean checkedIn;
    private String numberOfBags;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Flight flight;
}
