package org.microservices.emailservice.controllers;

import org.microservices.emailservice.dto.EmailDto;
import org.microservices.emailservice.responses.EmailResponse;
import org.microservices.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailDto emailDto) {
        emailService.sendEmail(emailDto);
        return ResponseEntity.ok(new EmailResponse("Email sent successfully", true));
    }

    @PostMapping("/sendMultiple")
    public ResponseEntity<EmailResponse> sendEmails(@RequestBody List<EmailDto> emailDtos) {
        emailService.sendEmails(emailDtos);
        return ResponseEntity.ok(new EmailResponse("Emails sent successfully", true));
    }
}