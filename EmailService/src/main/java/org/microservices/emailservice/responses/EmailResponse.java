package org.microservices.emailservice.responses;

import lombok.Getter;

@Getter
public class EmailResponse {
    private String message;
    private boolean status;

    public EmailResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

}
