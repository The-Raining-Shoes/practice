package com.example.item.auditionParctice.chainResp;

/**
 * <b>(LeaderHandler)</b>
 *
 * @author Rainy 2023-01-03 21:17:24
 * @version 1.0.0
 */
public class LeaderHandler extends Handler {

    @Override
    void doWork(Integer count) {
        if (count < 10) {
            System.out.println("LeaderHandler处理了消息");
        } else {
            setNextHandler(new BossHandler());
            nextHandler.doWork(count);
        }
    }

}
