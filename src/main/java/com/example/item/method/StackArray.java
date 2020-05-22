package com.example.item.method;

import java.util.List;
import java.util.Stack;

/**
 * 堆排序
 *
 * @author HXM
 * @date 2020年05月22日 14:27
 */
public class StackArray {
    public static void main(String[] args) {
        List<Integer> list = StaticList.getList;
        Stack<Integer> stack = new Stack<>();
        int organSize = list.size();
        for (int i = 0; i < organSize; i++) {
            int temp = list.get(0);
            int min = 0;
            for (int j = 0; j < list.size(); j++) {
                if (temp > list.get(j)) {
                    temp = list.get(j);
                    min = j;
                }
            }
            stack.push(list.get(min));
            list.remove(min);
        }
        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
