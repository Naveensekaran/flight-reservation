package com.reservation.flight_reservation.controller;

import com.reservation.flight_reservation.dto.ReservationRequestDto;
import com.reservation.flight_reservation.dto.ReservationUpdateRequestDto;
import com.reservation.flight_reservation.model.Reservation;
import com.reservation.flight_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/completeReservation")
    public Reservation completeReservation(@RequestBody ReservationRequestDto reservationRequest) {
        Reservation reservation =  reservationService.bookFlight(reservationRequest);
        return reservation;
    }

    @GetMapping("/findReservation/{id}")
    public Reservation findReservation(@PathVariable("id") String id) {
        return reservationService.findReservationById(id);
    }

    @PostMapping("/updateReservation")
        public Reservation updateReservation(@RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
            String id  = reservationUpdateRequestDto.getId();
            Reservation reservation = reservationService.findReservationById(id);
            reservation.setCheckedIn(reservationUpdateRequestDto.isCheckedIn());
            reservation.setNumberOfBags(String.valueOf(reservationUpdateRequestDto.getNumberOfBags()));
            return reservationService.updateReservation(reservation);
        }

}
