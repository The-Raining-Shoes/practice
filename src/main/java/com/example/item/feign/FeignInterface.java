//package com.example.item.feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * <b>(FeignInterface)</b>
// *
// * @author Rainy
// * @version 1.0.0
// * @date 2022/6/6
// */
//@FeignClient(
//        name = "item-service",
//        url="http://localhost:8090"
//)
//public interface FeignInterface {
//
//    /**
//     * 测试
//     * @return String
//     */
//    @RequestMapping(value = "/feignTest/test",method = RequestMethod.GET)
//    @ResponseBody
//    String feignTest();
//
//}
