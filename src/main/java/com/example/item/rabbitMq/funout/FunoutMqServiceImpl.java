package com.example.item.rabbitMq.funout;

import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FunoutMqServiceImpl {

    @Setter(onMethod_ = @Autowired)
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userId, String productId, int num) {
        System.out.println(userId);
        System.out.println(productId);
        System.out.println(num);
        // 1.根据商品ID查询库存是否重充足
        // 2.保存订单
        String orderId = UUID.randomUUID().toString();
        // 3.通过MQ来完成消息的分发
        // 参数1：交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName = "spring_fanout_test";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

}