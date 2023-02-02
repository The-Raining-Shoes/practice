package com.example.item.auditionParctice.flyWeight;

/**
 * <b>(MobileBike)</b>
 *
 * @author Rainy 2023-01-05 13:13:14
 * @version 1.0.0
 */
public class MobileBike extends Bike {

    private final Integer bikeId;

    public MobileBike(Integer bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    void ride(String userName) {
        state = 1;
        System.out.println(userName + "骑着" + bikeId + "出行");
    }

    @Override
    void back() {
        state = 0;
    }

}
