package com.reservation.flight_reservation.controller;

import com.reservation.flight_reservation.model.Flight;
import com.reservation.flight_reservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("admin/addFlight")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping("/findFlights")
    public List<Flight> findFlights(@RequestParam("departDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departDate,  @RequestParam("destination") String destination) {
        return flightService.getAllFlights(departDate,destination);
    }
}
