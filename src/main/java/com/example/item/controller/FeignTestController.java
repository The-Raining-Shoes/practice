package com.example.item.controller;

import com.example.item.feign.FeignInterface;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>(FeignTest)</b>
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/6/6
 */
@RestController
@RequestMapping(value = "/feignTest")
public class FeignTestController {

    @Setter(onMethod_ = @Autowired)
    private FeignInterface feignInterface;

    @RequestMapping(value = "/feignTest")
    public String feignTest() {
        System.out.println(1);
        return feignInterface.feignTest();
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "成功";
    }

}
