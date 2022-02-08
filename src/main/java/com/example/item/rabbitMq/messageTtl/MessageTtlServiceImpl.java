package com.example.item.rabbitMq.messageTtl;

import lombok.Setter;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class MessageTtlServiceImpl {

    @Setter(onMethod_ = @Autowired)
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userId, String productId, int num) {
        System.out.println(productId);
        System.out.println(num);
        // 1.根据商品ID查询库存是否重充足
        // 2.保存订单
        String orderId = UUID.randomUUID().toString();
        // 3.通过MQ来完成消息的分发
        // 参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName = "message_ttl_direct_exchange";
        String routingKey = "message_ttl";
        MessagePostProcessor messagePostProcessor = message -> {
            // 过期时间
            message.getMessageProperties().setExpiration("10000");
            message.getMessageProperties().setContentEncoding(StandardCharsets.UTF_8.toString());
            return message;
        };
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId, messagePostProcessor);
    }

}
