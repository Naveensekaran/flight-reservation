package com.reservation.flight_reservation.controller;

import com.reservation.flight_reservation.dto.ReservationRequestDto;
import com.reservation.flight_reservation.dto.ReservationUpdateRequestDto;
import com.reservation.flight_reservation.model.Reservation;
import com.reservation.flight_reservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/completeReservation")
    public Reservation completeReservation(@RequestBody ReservationRequestDto reservationRequest) {
        Reservation reservation =  reservationService.bookFlight(reservationRequest);
        return reservation;
    }

    @GetMapping("/findReservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        return reservationService.findReservationById(id);
    }

    @PostMapping("/updateReservation")
        public Reservation updateReservation(@RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
            Long id  = reservationUpdateRequestDto.getId();
            logger.info("Finding reservation with id: {}", id);
            Reservation reservation = reservationService.findReservationById(id);
            reservation.setCheckedIn(reservationUpdateRequestDto.isCheckedIn());
            reservation.setNumberOfBags(String.valueOf(reservationUpdateRequestDto.getNumberOfBags()));
            return reservationService.updateReservation(reservation);
        }

}
