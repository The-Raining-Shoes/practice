package com.example.item.auditionParctice.single;

/**
 * enum 枚举是什么？枚举本身也是一个Class类
 */
public enum EnumSingle {

    test("sad","dsa");

    EnumSingle(String a, String b){
        this.code = a;
        this.reason = b;
    }

    public static EnumSingle getInstance(){
        return test;
    }
    private String code;
    private String reason;

    public String getCode(){
        return code;
    }

    public String getReason(){
        return reason;
    }

}
