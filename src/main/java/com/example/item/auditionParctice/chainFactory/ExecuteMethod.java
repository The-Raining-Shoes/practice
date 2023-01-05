package com.example.item.auditionParctice.chainFactory;

/**
 * <b>(Execute)</b>
 *
 * @author Rainy 2023-01-03 21:35:11
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        ChainHandler chainHandler1 = new ChainHandler("test", 10, true);
        ChainHandler chainHandler2 = new ChainHandler("test3", 5, true);
        ChainHandler chainHandler3 = new ChainHandler("test", 11, true);
        ChainFactory.registerChainHandler(chainHandler1);
        ChainFactory.registerChainHandler(chainHandler2);
        ChainFactory.registerChainHandler(chainHandler3);
        ChainFactory.sort();
        ChainFactory.route("test3");
    }

}
