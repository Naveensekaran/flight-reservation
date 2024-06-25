package com.reservation.flight_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Abstractor {

    private String roleType;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
