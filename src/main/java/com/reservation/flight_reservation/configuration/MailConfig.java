package com.reservation.flight_reservation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost");  // Replace with your SMTP host
        mailSender.setPort(123);               // Replace with your SMTP port
        mailSender.setUsername("your.username"); // Replace with your SMTP username
        mailSender.setPassword("your.password"); // Replace with your SMTP password

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");  // Enable debug mode for troubleshooting

        return mailSender;
    }
}
