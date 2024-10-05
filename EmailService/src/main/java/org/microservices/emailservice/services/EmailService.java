package org.microservices.emailservice.services;

import org.microservices.emailservice.Exceptions.EmailSendException;
import org.microservices.emailservice.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailDto email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.emailTo());
            message.setSubject(email.subject());
            message.setText(email.text());
            mailSender.send(message);
        } catch (MailException e) {
            // Log the error and handle it appropriately
            // You could throw a custom exception or log the error
            throw new EmailSendException("Failed to send email", e);
        }
    }
}
