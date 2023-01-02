package com.example.item.method.classInsideMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>(InsideClassTwo)</b>
 *
 * @author Rainy 2023-01-01 11:09:24
 * @version 1.0.0
 */
public class InsideClassTwo {

    private final List<InsideClassOne> insideClassOneList = new ArrayList<>();

    public InsideClassOne rule() {
        return new InsideClassOne(this);
    }

    List<InsideClassOne> getRules() {
        return this.insideClassOneList;
    }

}
