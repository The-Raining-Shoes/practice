package com.example.item.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 注册监听
 */
@Service
public class Receiver {

    @RabbitListener(queues = {"sh-elastic-relay-one-queue"}, containerFactory = "relayQueueFactory")
    public void listenerOne() throws Exception {
        System.out.println(1);
    }

}
