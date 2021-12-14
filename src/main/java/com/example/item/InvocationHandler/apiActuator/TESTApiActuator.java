package com.example.item.InvocationHandler.apiActuator;

import org.springframework.web.client.RestTemplate;

public class TESTApiActuator extends BaseApiActuator {

    public TESTApiActuator(RestTemplate restTemplate, String name, String password) {
        super(restTemplate,name,password);
    }

}
