package com.tri.reviewms.messaging;

import com.tri.reviewms.Models.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review) {
        rabbitTemplate.convertAndSend("getMessageQueue", review);
    }
}
