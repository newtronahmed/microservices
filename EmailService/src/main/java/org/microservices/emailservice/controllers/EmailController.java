package org.microservices.emailservice.controllers;


import jakarta.validation.Valid;

import org.microservices.emailservice.EmailResponse;
import org.microservices.emailservice.dto.EmailDto;
import org.microservices.emailservice.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody @Valid EmailDto emailDto) {

        emailService.sendEmail(emailDto);

//        return new ResponseEntity<>(email, HttpStatus.CREATED);
        return new ResponseEntity<>(new EmailResponse("Email sent successfully", true), HttpStatus.CREATED);
    }

}
