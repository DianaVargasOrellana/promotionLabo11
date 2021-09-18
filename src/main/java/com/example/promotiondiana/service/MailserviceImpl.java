package com.example.promotiondiana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailserviceImpl {
        @Autowired
        private JavaMailSender emailSender;

        public void sendSimpleMessage(String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("dianav715@gmail.com");
            message.setTo("edson@gmail.com");
            message.setSubject("Promotion birthday");
            message.setText(text);
            emailSender.send(message);
            emailSender.send(message);
        }

}

