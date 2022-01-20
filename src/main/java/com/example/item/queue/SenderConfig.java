package com.example.item.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Bean
    public Queue testQueueOne() {
        return new Queue("sh-elastic-relay-one-queue");
    }

}
