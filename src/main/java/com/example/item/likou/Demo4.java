package com.example.item.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>(Demo4)</b>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/4
 */
public class Demo4 {

    public static void main(String[] args) {
        System.out.println(new Demo4().minimumAbsDifference(new int[]{-10, -4, 4, 10}));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = arr[i + 1] - arr[i];
            if (count < best) {
                best = count;
                result.clear();
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            } else if (count == best) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }
        return result;
    }
}
