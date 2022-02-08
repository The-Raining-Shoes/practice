package com.example.item.rabbitMq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "duanxin.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.duanxin.*"
))
@Service
public class TopicConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("topic模式接收到了消息" + message);
    }

}
