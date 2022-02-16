package com.example.item.rabbitMq.funout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunoutMqConfig {

    // 定义交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("spring_fanout_test", true, false);
    }

    // 定义队列
    @Bean
    public Queue smsQueue() {
        return new Queue("spring_sms_queue",true,false,false);
    }

    @Bean
    public Queue messageQueue() {
        return new Queue("spring_message_queue");
    }

    @Bean
    public Queue emailQueue() {
        return new Queue("spring_email_queue");
    }

    // 完成绑定关系
    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding messageBinding() {
        return BindingBuilder.bind(messageQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }

}
