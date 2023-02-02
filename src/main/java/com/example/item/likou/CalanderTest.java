package com.example.item.likou;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>(CalanderTest)</b>
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/5
 */
public class CalanderTest {

    List<int[]> list;

    public static void main(String[] args) {
        CalanderTest calanderTest = new CalanderTest();
        System.out.println(calanderTest.add(1, 5));
        System.out.println(calanderTest.add(2, 6));
        System.out.println(calanderTest.add(5, 10));
        System.out.println(calanderTest.add(15, 30));
    }

    public CalanderTest() {
        list = new ArrayList<>();
    }

    public boolean add(int start, int end) {
        for (int[] ints : list) {
            if (start < ints[1] && end > ints[0]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

}
