package org.microservices.grpc.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class EmailMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String to;
    private String subject;
    private String body;

    public EmailMessage() {
        // No-argument constructor
    }

    public EmailMessage(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    // Getters and setters

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}