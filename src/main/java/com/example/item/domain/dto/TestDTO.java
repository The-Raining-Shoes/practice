package com.example.item.domain.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestDTO {

    @Value("${server.port}")
    private String testCode;

}
