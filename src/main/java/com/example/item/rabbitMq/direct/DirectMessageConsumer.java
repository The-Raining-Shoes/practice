package com.example.item.rabbitMq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"spring_message_direct_queue"})
public class DirectMessageConsumer {

    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("message接收到了消息" + message);
    }

}
