package com.example.item.auditionParctice.chainDemo;

/**
 * <b>(ChainInterface)</b>
 *
 * @author Rainy 2023-01-31 09:50:40
 * @version 1.0.0
 */
public abstract class ChainDemo {

    public ChainDemo nextChain;

    public void setChainDemo(ChainDemo chainDemo) {
        this.nextChain = chainDemo;
    }

    public abstract void doFilter(Integer i);


}
