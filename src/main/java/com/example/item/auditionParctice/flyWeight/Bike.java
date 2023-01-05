package com.example.item.auditionParctice.flyWeight;

import lombok.Getter;

/**
 * <b>(Bike)</b>
 *
 * @author Rainy 2023-01-05 13:12:00
 * @version 1.0.0
 */
public abstract class Bike {

    @Getter
    protected Integer state = 0;

    abstract void ride(String userName);

    abstract void back();

}
