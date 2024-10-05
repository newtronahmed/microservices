package org.microservices.emailservice.service;

import org.microservices.emailservice.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.emailTo());
        message.setSubject(emailDto.subject());
        message.setText(emailDto.text());
        mailSender.send(message);
    }

    public void sendEmails(List<EmailDto> emailDtos) {
        for (EmailDto emailDto : emailDtos) {
            sendEmail(emailDto);
        }
    }
}