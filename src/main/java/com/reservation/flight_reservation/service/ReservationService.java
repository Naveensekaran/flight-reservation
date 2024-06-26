package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.dto.ReservationRequestDto;
import com.reservation.flight_reservation.exceptions.FlightNotFound;
import com.reservation.flight_reservation.exceptions.ReservationNotFound;
import com.reservation.flight_reservation.model.Flight;
import com.reservation.flight_reservation.model.Passenger;
import com.reservation.flight_reservation.model.Reservation;
import com.reservation.flight_reservation.repository.FlightRepository;
import com.reservation.flight_reservation.repository.PassengerRepository;
import com.reservation.flight_reservation.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookFlight(ReservationRequestDto reservationRequest) {
        logger.info("Booking flight for passenger: {}", reservationRequest.getPassengerFirstName());
        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        passengerRepository.save(passenger);
        logger.info("Passenger details saved: {}", passenger.getEmail());

        Flight flight = flightRepository.findByFlightId(reservationRequest.getFlightId());
        if (flight == null) {
            String message = "No flight found with id " + reservationRequest.getFlightId();
            logger.error(message);
            throw new FlightNotFound("No flight found with id "+reservationRequest.getFlightId());
        }
        Reservation reservation = new Reservation();
        reservation.setPassenger(passenger);
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);

        final Reservation savedReservation = reservationRepository.save(reservation);

        logger.info("Reservation created successfully with flight: {}", savedReservation.getFlight());
        return savedReservation;

    }

    public Reservation findReservationById(Long id) {
        logger.info("Finding reservation with id: {}", id);
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if(!reservation.isPresent()) {
            throw new ReservationNotFound("No reservation found with id "+id);
        }
        logger.info("Reservation found");
        return reservation.get();
    }

    public Reservation updateReservation(Reservation reservation) {
        logger.info("Updating reservation");
        return reservationRepository.save(reservation);
    }
}
