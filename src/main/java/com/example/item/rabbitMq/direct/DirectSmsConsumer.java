package com.example.item.rabbitMq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"spring_sms_direct_queue"})
public class DirectSmsConsumer {

    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("sms接收到了消息" + message);
    }

}
