package com.example.item.zrExam.aaabbccccdd;

/**
 * @author HXM
 * @date 2020年09月21日 16:38
 */
public class ScoutSum {
    public static void main(String[] args) {
        String str = "aaabbcccccdd";
        int length = str.length();
        StringBuilder result = new StringBuilder();
        char firstWord = str.charAt(0);
        int sum = 1;
        for (int i = 1; i < length; i++) {
            if (firstWord == str.charAt(i)) {
                sum += 1;
                continue;
            }
            result.append(sum).append(firstWord);
            firstWord = str.charAt(i);
            sum = 1;
        }
        // 加上最后一个字符及个数，并打印输出
        System.out.println(result.append(sum).append(firstWord));
    }
}
