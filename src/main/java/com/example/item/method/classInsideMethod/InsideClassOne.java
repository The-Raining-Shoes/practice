package com.example.item.method.classInsideMethod;

import lombok.Getter;

/**
 * <b>(InsideClassOne)</b>
 *
 * @author Rainy 2023-01-01 11:09:18
 * @version 1.0.0
 */
public class InsideClassOne implements Comparable<InsideClassOne> {

    public final InsideClassTwo insideClassTwo;

    @Getter
    private int order;

    public InsideClassOne(InsideClassTwo someStuff2) {
        this.insideClassTwo = someStuff2;
    }

    @Override
    public int compareTo(InsideClassOne o) {
        return this.order - o.getOrder();
    }

    public InsideClassOne order(int order) {
        this.order = order;
        return this;
    }

    public InsideClassTwo end() {
        this.insideClassTwo.getRules().add(this);
        return this.insideClassTwo;
    }

}
