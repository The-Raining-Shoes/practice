package com.example.item;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] strings1 = {1, 3};
        int[] strings2 = {2, 4};
        int[] strings3 = {3, 6};
        int[] strings4 = {7, 9};
        list.add(strings1);
        list.add(strings2);
        list.add(strings3);
        list.add(strings4);
        boolean ifTrue = true;
        while (ifTrue) {
            outCycle:
            for (int i = 0; i < list.size(); i++) {
                for (int j = 1; j < list.size(); j++) {
                    int[] ints1 = list.get(i);
                    int[] ints2 = list.get(j);
                    if (((ints1[0] >= ints2[0] && ints1[0] <= ints2[1]) ||
                            (ints1[1] >= ints2[0] && ints1[1] <= ints2[1])) && (ints1[0] != ints2[0]) && (ints1[1] != ints2[1]))
                    {
                        int[] i1 = new int[]{Math.min(ints1[0], ints2[0]), Math.max(ints1[1], ints2[1])};
                        list.remove(ints1);
                        list.remove(ints2);
                        list.add(i1);
                        break outCycle;
                    }
                }
                if (i == list.size() - 1) {
                    ifTrue = false;
                }
            }
        }
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }

}