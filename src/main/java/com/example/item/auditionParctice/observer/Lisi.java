package com.example.item.auditionParctice.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>(Lisi)</b>
 * 借钱方
 *
 * @author Rainy 2023-01-02 21:10:22
 * @version 1.0.0
 */
public class Lisi implements Debit {

    List<Credit> list = new ArrayList<>();

    @Override
    public void borrow(Credit credit) {
        list.add(credit);
    }

    @Override
    public void notifyCredits() {
        list.forEach(Credit::notifyCredit);
    }

}
