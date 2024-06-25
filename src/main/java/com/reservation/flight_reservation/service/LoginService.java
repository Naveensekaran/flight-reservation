package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.dto.LoginDto;
import com.reservation.flight_reservation.model.User;
import com.reservation.flight_reservation.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger logger= LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User userdata) {
        userdata.setPassword(passwordEncoder.encode(userdata.getPassword()));
        User user = loginRepository.save(userdata);
        logger.info("User registered successfully");
        return user;
    }

    public User loginUser(LoginDto loginDto) {
        User user = loginRepository.findByEmailAndPassword(loginDto);
        if (user == null) {
            logger.error("User not found");
            return null;
        }
        logger.info("User logged in");
        return user;
    }
}
