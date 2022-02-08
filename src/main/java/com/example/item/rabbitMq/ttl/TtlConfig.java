package com.example.item.rabbitMq.ttl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TtlConfig {

    @Bean
    public DirectExchange ttlDirectExchange() {
        return new DirectExchange("ttl_direct_exchange");
    }

    @Bean
    public Queue directTtlQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        return new Queue("direct_ttl_queue", true, false, false, args);
    }

    @Bean
    public Binding ttlBinding(){
        return BindingBuilder.bind(directTtlQueue()).to(ttlDirectExchange()).with("ttl");
    }

}
