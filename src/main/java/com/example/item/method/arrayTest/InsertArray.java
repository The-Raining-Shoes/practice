package com.example.item.method.arrayTest;

import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 *
 * @author HXM
 * @date 2020年05月22日 14:57
 */
public class InsertArray {
    public static void main(String[] args) {
        List<Integer> list = StaticList.getList;
        int len = list.size();//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for (int i = 1; i < len; i++) {//因为第一次不用，所以从1开始
            insertNum = list.get(i);
            int j = i - 1;//序列元素个数
            while (j >= 0 && list.get(i) > insertNum) {//从后往前循环，将大于insertNum的数向后移动
                list.set(j + 1, list.get(j));//元素向后移动
                j--;
            }
            list.set(j + 1, insertNum);//找到位置，插入当前元素
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
