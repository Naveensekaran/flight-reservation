package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.dto.ReservationRequestDto;
import com.reservation.flight_reservation.model.Flight;
import com.reservation.flight_reservation.model.Passenger;
import com.reservation.flight_reservation.model.Reservation;
import com.reservation.flight_reservation.repository.FlightRepository;
import com.reservation.flight_reservation.repository.PassengerRepository;
import com.reservation.flight_reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookFlight(ReservationRequestDto reservationRequest) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        passengerRepository.save(passenger);

        Flight flight = flightRepository.findByFlightId(reservationRequest.getFlightId());

        Reservation reservation = new Reservation();
        reservation.setPassenger(passenger);
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);

        final Reservation savedReservation = reservationRepository.save(reservation);
        return reservation;

    }

    public Reservation findReservationById(String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.get();
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
