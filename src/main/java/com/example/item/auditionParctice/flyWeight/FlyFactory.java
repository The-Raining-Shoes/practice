package com.example.item.auditionParctice.flyWeight;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>(FlyFactory)</b>
 *
 * @author Rainy 2023-01-05 13:15:42
 * @version 1.0.0
 */
public class FlyFactory {

    @Getter
    public static FlyFactory flyFactory = new FlyFactory();

    Set<Bike> bikes = new HashSet<>();

    private FlyFactory() {
        for (int i = 0; i < 2; i++) {
            bikes.add(new MobileBike(i));
        }
    }

    public Bike getBike() {
        for (Bike bike : bikes) {
            if (bike.state == 0) {
                return bike;
            }
        }
        return null;
    }

}
