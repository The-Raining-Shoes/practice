package com.example.item.InvocationHandler;

import com.example.item.InvocationHandler.annotation.RemoteField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestHttpMethodDTO {

    @RemoteField(value = "test_code")
    public String code;

    @RemoteField(value = "mobile")
    public String number;

    @RemoteField(value = "type")
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
