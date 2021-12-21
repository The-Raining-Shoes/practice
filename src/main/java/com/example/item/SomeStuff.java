package com.example.item;

import java.util.Scanner;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; scanner.hasNext(); ) {
            System.out.println(scanner.next());
        }
    }

    static int getCount(int dayCount, int num) {
        System.out.println("天数" + dayCount + "-" + num);
        int countNum = (num + 1) * 2;
        int day = dayCount - 1;
        if (dayCount == 1) {
            return num;
        }
        return getCount(day, countNum);
    }

}