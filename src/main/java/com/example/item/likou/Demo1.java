package com.example.item.likou;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <b>(Demo1)</b>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/1
 */
public class Demo1 {

    public static void main(String[] args) {
        final long currentTimeMillis = System.currentTimeMillis();
        int[] result = new int[]{3, 3};
        final int[] ints = twoSum(result, 6);
        System.out.println(Arrays.toString(ints));
        System.out.println("执行时间" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 1.力扣大神解法
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
            // 放入target补数
            map.put(target - nums[i], i);
        }
        //       2.双重循环暴力解法
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums.length - 1; j > i; j--) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                    break a;
//                }
//            }
//        }
        return result;
    }

}
