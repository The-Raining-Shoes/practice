package com.example.item.queue;

import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Setter(onMethod_ = @Autowired)
    private AmqpTemplate amqpTemplate;

    public void sendTemplate() {
        amqpTemplate.convertAndSend("sh-elastic-relay-one-queue", "测试");
    }

}
