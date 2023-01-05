package com.example.item.auditionParctice.chainFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>(ChainFactory)</b>
 *
 * @author Rainy 2023-01-03 21:29:32
 * @version 1.0.0
 */
public class ChainFactory {

    static List<ChainHandler> list = new ArrayList<>();

    static void registerChainHandler(ChainHandler chainHandler) {
        list.add(chainHandler);
    }

    static void sort() {
        Collections.sort(list);
    }

    static void route(String code) {
        List<ChainHandler> chainHandlers = new ArrayList<>();
        for (ChainHandler chainHandler : list) {
            if (chainHandler.testBehavior(code)) {
                chainHandlers.add(chainHandler);
            }
        }
        if (chainHandlers.size() == 0) {
            System.out.println("当前无".concat(code).concat("对应处理器"));
            return;
        }
        for (ChainHandler chainHandler : chainHandlers) {
            chainHandler.dealMethod();
        }
    }

}
