package com.reservation.flight_reservation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Abstractor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
