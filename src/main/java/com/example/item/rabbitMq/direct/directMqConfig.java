package com.example.item.rabbitMq.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class directMqConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("spring_direct_test", true, false);
    }

    // 定义队列
    @Bean
    public Queue directSmsQueue() {
        return new Queue("spring_sms_direct_queue");
    }

    @Bean
    public Queue directMessageQueue() {
        return new Queue("spring_message_direct_queue");
    }

    @Bean
    public Queue directEmailQueue() {
        return new Queue("spring_email_direct_queue");
    }

    @Bean
    public Binding directSmsBinding(){
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("test");
    }

    @Bean
    public Binding directMessageBinding(){
        return BindingBuilder.bind(directMessageQueue()).to(directExchange()).with("test");
    }

    @Bean
    public Binding directEmailBinding(){
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("test_test");
    }

}
