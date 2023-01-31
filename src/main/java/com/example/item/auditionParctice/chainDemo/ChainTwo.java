package com.example.item.auditionParctice.chainDemo;

/**
 * <b>(ChainTwo)</b>
 *
 * @author Rainy 2023-01-31 09:54:46
 * @version 1.0.0
 */
public class ChainTwo extends ChainDemo {

    @Override
    public void doFilter(Integer i) {
        if (i < 10) {
            System.out.println("ChainTwo处理了");
        } else {
            setChainDemo(new ChainThree());
            nextChain.doFilter(i);
        }
    }

}
