package com.reservation.flight_reservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    private String EMAIL_BODY = "Please find your Itinerary attached.";

    private String EMAIL_SUBJECT = "Itinerary for your Flight";

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    public void sendItenary(String toAddress,String filePath){
        LOGGER.info("Inside sendItinerary()");
        MimeMessage message=javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(EMAIL_BODY);
            messageHelper.addAttachment("Itinearary", new File(filePath));
            javaMailSender.send(message);
            LOGGER.info("Email sent: "+message);
        } catch (MessagingException e) {
            LOGGER.error(" Error Inside sendItinerary(): {}",e);
            System.out.println("Exception inside sendItinerary" + e);
        }
    }
}
