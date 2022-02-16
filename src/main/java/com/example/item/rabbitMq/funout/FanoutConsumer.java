package com.example.item.rabbitMq.funout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"spring_message_queue"})
@Service
public class FanoutConsumer {

    @RabbitHandler
    public void receiveMessage(String message, Channel channel, CorrelationData correlationData) {
        System.out.println("spring测试接收到了消息是：" + message);
    }

}
