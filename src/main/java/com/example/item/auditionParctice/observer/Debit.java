package com.example.item.auditionParctice.observer;

/**
 * <b>(Debit)</b>
 *
 * @author Rainy 2023-01-02 21:06:59
 * @version 1.0.0
 */
public interface Debit {

    void borrow(Credit credit);

    void notifyCredits();

}
