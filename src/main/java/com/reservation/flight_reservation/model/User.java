package com.reservation.flight_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Abstractor {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles;
}
