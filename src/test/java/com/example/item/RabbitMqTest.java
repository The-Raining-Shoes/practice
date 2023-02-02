//package com.example.item;
//
//import com.example.item.rabbitMq.direct.DirectMqServiceImpl;
//import com.example.item.rabbitMq.funout.FunoutMqServiceImpl;
//import com.example.item.rabbitMq.messageTtl.MessageTtlServiceImpl;
//import com.example.item.rabbitMq.topic.TopicMqServiceImpl;
//import com.example.item.rabbitMq.ttl.TtlMqServiceImpl;
//import lombok.Setter;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class RabbitMqTest {
//
//    @Setter(onMethod_ = @Autowired)
//    private FunoutMqServiceImpl rabbitMqService;
//    @Setter(onMethod_ = @Autowired)
//    private DirectMqServiceImpl directMqService;
//    @Setter(onMethod_ = @Autowired)
//    private TopicMqServiceImpl topicMqService;
//    @Setter(onMethod_ = @Autowired)
//    private TtlMqServiceImpl ttlMqService;
//    @Setter(onMethod_ = @Autowired)
//    private MessageTtlServiceImpl messageTtlService;
//
//    @Test
//    public void test() {
//        rabbitMqService.makeOrder("TEST_CODE", "TEST_ID", 10);
//    }
//
//    @Test
//    public void directTest() {
//        directMqService.makeOrder("TEST_CODE", "TEST_ID", 10);
//    }
//
//    @Test
//    public void topicTest() {
//        topicMqService.makeOrder("TEST_CODE", "TEST_ID", 10);
//    }
//
//    @Test
//    public void ttlTest() {
//        ttlMqService.makeOrder("TEST_CODE", "TEST_ID", 10);
//    }
//
//    @Test
//    public void messageTtlTest() {
//        messageTtlService.makeOrder("TEST_CODE", "TEST_ID", 10);
//    }
//
//}
