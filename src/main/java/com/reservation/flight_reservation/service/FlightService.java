package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.exceptions.FlightNotFound;
import com.reservation.flight_reservation.model.Flight;
import com.reservation.flight_reservation.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    private static final Logger logger= LoggerFactory.getLogger(FlightService.class);

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        Flight flight1 =  flightRepository.save(flight);
        if (flight1 == null) {
            throw new FlightNotFound("Flight not added: " + flight);
        }
        logger.info("Flight added: {}", flight1);
        return flight1;
    }
    public List<Flight> getAllFlights(Date departDate, String destination) {
        List<Flight> flights = flightRepository.findByDateOfDepartureAndArrivalCity(departDate, destination);
        logger.debug("Found {} flights departing on {} to {}", flights.size(), departDate, destination);
        return flights;
    }
}
