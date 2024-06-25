package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.model.Flight;
import com.reservation.flight_reservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public List<Flight> getAllFlights(Date departDate, String destination) {
        return flightRepository.findByDateOfDepartureAndArrivalCity(departDate, destination);
    }
}
