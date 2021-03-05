package com.example.item.controller;

import com.alipay.api.AlipayApiException;
import com.example.item.domain.dto.LoginDTO;
import com.example.item.domain.entity.AlipayBean;
import com.example.item.service.PayService;
import com.example.item.utils.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HXM
 * @date 2020年11月09日 15:57
 */

/* 订单接口 */
@RestController()
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PayService payService;//调用支付服务​

    /*阿里支付*/
    @PostMapping(value = "/alipay")
    public String alipay(String out_trade_no, String subject, String total_amount, String body) throws AlipayApiException {
        return payService.aliPay(new AlipayBean()
                .setBody(body)
                .setOut_trade_no(out_trade_no)
                .setTotal_amount(new StringBuffer().append(total_amount))
                .setSubject(subject));
    }

    @GetMapping(value = "/test")
    public LoginDTO test() {
        String a = "{\n" +
                   "    \"passAge\": 1,\n" +
                   "    \"type\": 1,\n" +
                   "    \"userName\": \"测试\"\n" +
                   "}";
        LoginDTO loginDTO = JsonUtil.fromJson(a, LoginDTO.class);
        System.out.println(loginDTO.getPassword());
        return JsonUtil.fromJson(a, LoginDTO.class);
    }
}
