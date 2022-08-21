package com.example.ResourceServiceV1.publisher;

import com.example.ResourceServiceV1.config.MessagingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class ResourcePublisher {
    @Autowired
    private RabbitTemplate template;


    public void sendEvent(Object body){
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, body);
    }
}
