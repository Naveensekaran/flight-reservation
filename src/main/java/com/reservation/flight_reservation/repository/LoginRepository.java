package com.reservation.flight_reservation.repository;

import com.reservation.flight_reservation.dto.LoginDto;
import com.reservation.flight_reservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
}
