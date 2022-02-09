package com.example.item.rabbitMq.messageTtl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 单独信息设置过期时间
 */
public class MessageTtlConfig {

    @Bean
    public DirectExchange messageTtlDirectExchange() {
        return new DirectExchange("message_ttl_direct_exchange");
    }

    @Bean
    public Queue messageDirectTtlQueue() {
        return new Queue("messaage_direct_ttl_queue");
    }

    @Bean
    public Binding messageTtlBinding() {
        return BindingBuilder.bind(messageDirectTtlQueue()).to(messageTtlDirectExchange()).with("message_ttl");
    }

}
