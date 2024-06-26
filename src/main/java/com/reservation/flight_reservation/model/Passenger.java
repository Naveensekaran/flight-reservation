package com.reservation.flight_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends Abstractor{
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
