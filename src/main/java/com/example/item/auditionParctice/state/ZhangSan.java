package com.example.item.auditionParctice.state;

/**
 * <b>(ZhangSan)</b>
 *
 * @author Rainy 2023-01-03 12:50:21
 * @version 1.0.0
 */
public class ZhangSan {

    private Behavior behavior;

    public ZhangSan(Behavior behavior) {
        this.behavior = behavior;
    }

    void changeState(Behavior behavior) {
        this.behavior = behavior;
    }

    void doWork() {
        System.out.println(behavior.doWork());
    }

}
