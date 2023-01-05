package com.example.item.auditionParctice.chainResp;

import lombok.Setter;

/**
 * <b>(Handler)</b>
 *
 * @author Rainy 2023-01-03 21:16:13
 * @version 1.0.0
 */
public abstract class Handler {

    @Setter
    protected Handler nextHandler;

    abstract void doWork(Integer number);

}
