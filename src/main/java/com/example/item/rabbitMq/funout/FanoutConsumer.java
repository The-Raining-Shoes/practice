package com.example.item.rabbitMq.funout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"spring_message_queue"})
@Service
public class FanoutConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("spring测试接收到了消息是：" + message);
    }

}
