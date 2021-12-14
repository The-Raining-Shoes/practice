package com.example.item.InvocationHandler;

public class TestCodeInterfaceImpl implements TestCodeInterface {

    @Override
    public String sysCode(String code) {
        System.out.println(code + "进来了");
        return code;
    }

    @Override
    public String sysName(String name) {
        System.out.println(name + "进来了");
        return name;
    }

}
