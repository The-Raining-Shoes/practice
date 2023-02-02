package com.example.item.auditionParctice.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>(Composite)</b>
 *
 * @author Rainy 2023-01-11 13:51:25
 * @version 1.0.0
 */
public class Composite implements Count {

    List<Count> countList = new ArrayList<>();

    public void add(Count count) {
        this.countList.add(count);
    }

    @Override
    public int sum() {
        int sum = 0;
        for (Count count : countList) {
            sum += count.sum();
        }
        return sum;
    }

}
