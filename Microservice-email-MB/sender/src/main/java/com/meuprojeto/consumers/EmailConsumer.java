package com.meuprojeto.consumers;

import com.meuprojeto.dtos.EmailDTO;
import com.meuprojeto.models.Email;
import com.meuprojeto.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService service;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO dto) {
        Email email = new Email(dto);

        service.sendEmail(email);

        System.out.println("Email status: " + email.getStatusEmail().toString());
    }
}
