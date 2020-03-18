package com.example.item;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author: HXM
 * @Date: 2020/1/6 11:15
 */
public class TestText {

    public static void main(String[] args) {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("M月dd日HH时");
        String now = df.format(ca.getTime());
        if (now.substring(0, 1).equals("0")) {
            now = now.substring(1);
        }
        System.out.println(now);
    }
}
