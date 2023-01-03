package com.example.item.auditionParctice.proxy;

/**
 * <b>(ExecuteMethod)</b>
 * 代理模式(与装饰模式、适配器模式很像，但是侧重接口隐藏)
 *
 * @author Rainy 2023-01-03 13:31:46
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        RealSubjectProxy realSubjectProxy = new RealSubjectProxy();
        realSubjectProxy.doWork();
    }

}
