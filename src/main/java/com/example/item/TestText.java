package com.example.item;

/**
 * @Author: HXM
 * @Date: 2020/1/6 11:15
 */
public class TestText {

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Threads());
        Thread thread2 = new Thread(new Threads());
        thread1.start();
        thread2.start();
    }
}

class Threads implements Runnable {

    @Override
    public void run() {
        TestText.sb.append("adc");
        System.out.println(TestText.sb.toString());
    }
}