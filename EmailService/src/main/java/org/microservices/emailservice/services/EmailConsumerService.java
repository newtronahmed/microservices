package org.microservices.emailservice.services;


import org.microservices.emailservice.dto.EmailDto;
import org.microservices.emailservice.dto.EmailMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
//public class RabbitMQListenerService {
//
//
//
//    @RabbitListener(queues = "emailQueue")
//
//}
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;

@Service
public class EmailConsumerService {
    @Autowired
    private JavaMailSender mailSender;
    @RabbitListener(queues = "emailQueue")
    public void receiveEmail(EmailMessage emailDto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getBody());
        mailSender.send(message);
    }
}

