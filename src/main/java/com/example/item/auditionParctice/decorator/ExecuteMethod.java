package com.example.item.auditionParctice.decorator;

/**
 * <b>(ExecuteMethod)</b>
 * 装饰器模式
 *
 * @author Rainy 2023-01-03 13:40:12
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        RobotDecorator robotDecorator = new RobotDecorator(new RobotWorker());
        robotDecorator.doOtherThing();
    }

}
