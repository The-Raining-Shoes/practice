package com.example.item.method.arrayTest;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 *
 * @author HXM
 * @date 2020年05月22日 14:29
 */
public class BubbleArray {
    public static void main(String[] args) {
        List<Integer> list = StaticList.getList;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
