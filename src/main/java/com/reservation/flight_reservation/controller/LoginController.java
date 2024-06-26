package com.reservation.flight_reservation.controller;
import com.reservation.flight_reservation.dto.LoginDto;
import com.reservation.flight_reservation.model.User;
import com.reservation.flight_reservation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

   @PostMapping("/register")
    public User register(@RequestBody User userdata){
       return loginService.registerUser(userdata);
   }

   @PostMapping("/login")
    public User login(@RequestBody LoginDto logindata, HttpServletResponse response) {
       User user = loginService.loginUser(logindata);
       return user;
   }
}
