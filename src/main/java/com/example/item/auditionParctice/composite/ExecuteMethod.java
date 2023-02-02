package com.example.item.auditionParctice.composite;

/**
 * <b>(ExecuteMethod)</b>
 *
 * @author Rainy 2023-01-11 13:53:23
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        Composite count = new Composite();
        count.add(new Leaf(100));
        count.add(new Leaf(10000));
        Composite composite = new Composite();
        composite.add(new Leaf(50));
        count.add(composite);
        System.out.println(count.sum());
    }

}
