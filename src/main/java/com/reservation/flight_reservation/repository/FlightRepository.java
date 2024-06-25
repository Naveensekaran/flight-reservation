package com.reservation.flight_reservation.repository;

import com.reservation.flight_reservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    List<Flight> findByDateOfDepartureAndArrivalCity(Date departureCity, String arrivalCity);

    Flight findByFlightId(String flightId);
}
