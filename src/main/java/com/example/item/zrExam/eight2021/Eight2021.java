package com.example.item.zrExam.eight2021;

import java.util.ArrayList;
import java.util.List;

public class Eight2021 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 7, 8, 10};
        List<List<Integer>> allOrderSub = getAllOrderSub(arr);
        if (allOrderSub.size() > 0) {
            for (List<Integer> list : allOrderSub) {
                System.out.println(list);
            }
        }
    }

    public static List<List<Integer>> getAllOrderSub(int[] arr) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int count = 1; count <= arr.length; count++) {
            for (int i = 0; i <= arr.length - count; i++) {
                List<Integer> list = new ArrayList<>();
                int j = 0;
                while (j < count) {
                    list.add(arr[i + j]);
                    j++;
                }
                resultList.add(list);
            }
        }
        return resultList;
    }

}
