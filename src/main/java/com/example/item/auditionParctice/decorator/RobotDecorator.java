package com.example.item.auditionParctice.decorator;

/**
 * <b>(RobotDecoretor)</b>
 *
 * @author Rainy 2023-01-03 13:38:35
 * @version 1.0.0
 */
public class RobotDecorator implements Robot {

    private final Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doOtherThing() {
        System.out.println("我还可以做其他事情");
        robot.doSomething();
        System.out.println("完成装饰功能");
    }

}
