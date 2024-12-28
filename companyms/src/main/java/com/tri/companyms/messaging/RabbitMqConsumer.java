package com.tri.companyms.messaging;

import com.tri.companyms.DTO.ReviewDTO;
import com.tri.companyms.Service.CompanyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    @Autowired
    CompanyService companyService;
    @RabbitListener(queues = "getMessageQueue")
    public void consumeMessage(ReviewDTO reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }
}

