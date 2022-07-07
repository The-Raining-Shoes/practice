package com.example.item.likou;

import java.util.TreeSet;

/**
 * <b>(MyCalendar)</b>
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/5
 */
public class MyCalendar {

    TreeSet<int[]> calendars;

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(0, 10));
        System.out.println(myCalendar.book(10, 25));
        System.out.println(myCalendar.book(24, 30));
    }

    public MyCalendar() {
        // 2.大佬解法
        calendars = new TreeSet<>((a, b) -> {
            if (a[1] <= b[0]) {
                return -1;
            } else if (a[0] >= b[1]) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public boolean book(int start, int end) {
        // 2.大佬解法
        int[] e = new int[]{start, end};
        return calendars.add(e);
        // 1.循环解法
        // List<int[]> list;
        //        for (int[] ints : list) {
//            if (start < ints[1] && end > ints[0]) {
//                return false;
//            }
//        }
//        list.add(new int[]{start, end});
//        return true;
    }

}
