package com.example.item.InvocationHandler;

import com.example.item.InvocationHandler.apiActuator.BaseApiActuator;
import org.springframework.web.client.RestTemplate;

public class TESTApiActuator extends BaseApiActuator {

    public TESTApiActuator(RestTemplate restTemplate, String name, String password) {
        super(restTemplate, name, password);
    }

}
