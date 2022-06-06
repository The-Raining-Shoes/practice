package com.example.item.auditionParctice.single;

/**
 * enum 枚举是什么？枚举本身也是一个Class类
 */
public enum EnumSingle {

    //
    test("test", "test");

    public static EnumSingle getInstance() {
        return test;
    }

    private final String code;
    private final String status;

    EnumSingle(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return this.code;
    }

    public String getStatus() {
        return status;
    }


}
