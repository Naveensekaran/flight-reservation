package com.reservation.flight_reservation.service;

import com.reservation.flight_reservation.dto.LoginDto;

import com.reservation.flight_reservation.model.User;
import com.reservation.flight_reservation.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

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
        logger.info("User registered successfully: {}", user.getEmail());
        return user;
    }

    public User loginUser(LoginDto loginDto) {
        User user = loginRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
        if (user == null) {
            logger.error("Login failed for email: {}", loginDto.getEmail());
            throw new UsernameNotFoundException("Invalid credentials");
        }
        logger.info("User logged in: {}", user.getEmail());
        return user;
    }
}
