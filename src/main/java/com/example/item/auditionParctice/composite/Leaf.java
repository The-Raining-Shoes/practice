package com.example.item.auditionParctice.composite;

/**
 * <b>(Leaf)</b>
 *
 * @author Rainy 2023-01-11 13:50:19
 * @version 1.0.0
 */
public class Leaf implements Count {

    int sum;

    public Leaf(int sum) {
        this.sum = sum;
    }

    @Override
    public int sum() {
        return sum;
    }

}
