package org.microservices.emailservice;

public class EmailResponse {
    private String message;
    private boolean status;

    public EmailResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}
