package com.example.item.auditionParctice.chainFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b>(ChainHandler)</b>
 *
 * @author Rainy 2023-01-03 21:29:55
 * @version 1.0.0
 */
@AllArgsConstructor
public class ChainHandler implements Comparable<ChainHandler> {

    @Getter
    private String behavior;
    @Getter
    private int order;
    @Getter
    private boolean ifNext;

    void dealMethod() {
        System.out.println(this.behavior + "|" + this.order + "|处理了信息");
    }

    boolean testBehavior(String behavior) {
        return this.behavior.equals(behavior);
    }

    @Override
    public int compareTo(ChainHandler o) {
        return this.order - o.getOrder();
    }

}
