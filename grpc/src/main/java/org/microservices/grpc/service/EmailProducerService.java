package org.microservices.grpc.service;

import org.microservices.grpc.dto.EmailMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class EmailProducerService {
    private static final Logger logger = LoggerFactory.getLogger(EmailProducerService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EMAIL_QUEUE = "emailQueue";

    public void sendEmail(EmailMessage emailMessage) {
        logger.info("Sending email message to queue: {} and queue is {}", emailMessage, EMAIL_QUEUE);
        rabbitTemplate.convertAndSend(EMAIL_QUEUE, emailMessage);
    }
}
