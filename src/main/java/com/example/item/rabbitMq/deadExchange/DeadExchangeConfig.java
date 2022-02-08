package com.example.item.rabbitMq.deadExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信队列
 */
@Configuration
public class DeadExchangeConfig {

    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }

    @Bean
    public Queue deadQueue(){
        return new Queue("dead.direct.queue",true);
    }

    @Bean
    public Binding deadQueueBinding(){
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange()).with("dead");
    }

}
