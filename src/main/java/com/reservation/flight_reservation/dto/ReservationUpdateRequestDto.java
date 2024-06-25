package com.reservation.flight_reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationUpdateRequestDto  {
    private String id;
    private boolean checkedIn;
    private int numberOfBags;
}
