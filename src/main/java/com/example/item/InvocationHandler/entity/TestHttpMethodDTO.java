package com.example.item.InvocationHandler.entity;

import com.example.item.InvocationHandler.annotation.RemoteFiled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestHttpMethodDTO {

    @RemoteFiled(value = "test_code")
    public String code;

    @RemoteFiled(value = "mobile")
    public String number;

    @RemoteFiled(value = "type")
    public String prodType;

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class TestHttpMethodVO {

        /**
         * 返回结果
         */
        public String result;

        /**
         * 返回描述
         */
        public String resultDesc;

    }

}
