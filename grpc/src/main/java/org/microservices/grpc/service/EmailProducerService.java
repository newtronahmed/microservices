package org.microservices.grpc.service;

import org.microservices.grpc.EmailMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EMAIL_QUEUE = "emailQueue";

    public void sendEmail(EmailMessage emailMessage) {
        rabbitTemplate.convertAndSend(EMAIL_QUEUE, emailMessage);
    }
}
