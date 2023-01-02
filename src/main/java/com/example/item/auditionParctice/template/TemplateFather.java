package com.example.item.auditionParctice.template;

/**
 * <b>(TemplateFather)</b>
 *
 * @author Rainy 2023-01-02 09:36:19
 * @version 1.0.0
 */
public abstract class TemplateFather {

    void cook(){
        System.out.println("模板方法执行开始");
        System.out.println(testCode());
        System.out.println(testName());
        System.out.println("模板方法执行结束");
    }

    abstract String testCode();
    abstract String testName();

}
