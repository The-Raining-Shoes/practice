//package com.example.item.controller;
//
//import com.example.item.utils.CheckUtils;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaProducer {
//
//    @Setter(onMethod_ = @Autowired)
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    // 发送消息
//    @GetMapping("/kafka/normal/{message}")
//    public void sendMessage1(@PathVariable("message") String normalMessage) {
//        kafkaTemplate.send("topic2", normalMessage);
//    }
//
//
//    @GetMapping("/kafka/callbackOne/{message}")
//    public void sendMessage2(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic1", callbackMessage).addCallback(success -> {
//            if (CheckUtils.isNotBlank(success)) {
//                // 消息发送到的topic
//                String topic = success.getRecordMetadata().topic();
//                // 消息发送到的分区
//                int partition = success.getRecordMetadata().partition();
//                // 消息在分区内的offset
//                long offset = success.getRecordMetadata().offset();
//                System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
//            }
//        }, failure -> {
//            System.out.println("发送消息失败:" + failure.getMessage());
//        });
//    }
//
//    @GetMapping("/kafka/callbackTwo/{message}")
//    public void sendMessage3(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic2", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("发送消息失败："+ex.getMessage());
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Object> result) {
//                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
//                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
//            }
//        });
//    }
//
//}
