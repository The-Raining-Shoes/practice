package com.example.item.auditionParctice.chainDemo;

/**
 * <b>(ChainOne)</b>
 *
 * @author Rainy 2023-01-31 09:52:14
 * @version 1.0.0
 */
public class ChainOne extends ChainDemo {

    @Override
    public void doFilter(Integer i) {
        if (i < 5) {
            System.out.println("ChainOne处理了");
        } else {
            setChainDemo(new ChainTwo());
            nextChain.doFilter(i);
        }
    }

}
