package com.example.item.rabbitMq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"spring_email_direct_queue"})
public class DirectEmailConsumer {

    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("email接收到了消息" + message);
    }

}
