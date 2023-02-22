package com.example.item.domain.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;

@Component
@Data
public class TestDTO {

    @Value("${server.port}")
    private String testCode;

    @Positive(message = "不行")
    private Integer code;

}
