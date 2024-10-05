package org.microservices.emailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EmailDto(
        @NotBlank @Email String emailTo,
        @NotBlank String subject,
        @NotBlank String text
) {
}