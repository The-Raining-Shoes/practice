package com.example.item.auditionParctice.chainResp;

/**
 * <b>(BossHandler)</b>
 *
 * @author Rainy 2023-01-03 21:20:12
 * @version 1.0.0
 */
public class BossHandler extends Handler {

    @Override
    void doWork(Integer number) {
        System.out.println("BossHandler处理了" + number);
    }

}
