package com.example.item.likou;

import java.util.Arrays;

/**
 * <b>(Demo3)</b>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长字串的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/4
 */
public class Demo3 {

    public static void main(String[] args) {
        System.out.println(new Demo3().lengthOfLongestSubstring("abcbbacd"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int n = s.length();
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

}
