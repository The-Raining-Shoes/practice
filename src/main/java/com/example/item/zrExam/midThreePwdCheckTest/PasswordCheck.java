package com.example.item.zrExam.midThreePwdCheckTest;

import java.util.regex.Pattern;

/**
 * 密码复杂度校验
 * 1.	密码长度为10到16位（包含10,16）
 * 2.	至少包含一个大写字母
 * 3.	至少包含一个小写字母
 * 4.	至少包含一个数字
 * 5.	至少包含一个中括号中的7个的特殊字符【!@#$%&*】
 * 6.	密码不能包括汉字
 *
 * @author HXM
 * @date 2020年04月10日 14:50
 */
public class PasswordCheck {
    public static void main(String[] args) {
        String regex = "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,16}";
        String source0 = "123";
        String source1 = "123abc";
        String source2 = "@123abc";
        String source3 = "A@123abc";
        String source4 = "A@123abcAAAAAAAddd";
        String source5 = "A@123abc中国AAA";
        String source6 = "Aa%AaAA@##AAA";
        String source7 = "a%Aa@#123K";
        String source8 = "fa%AaAA@##123";
        String source9 = "fa%AaAA@##123ddddddd";

        System.out.println("source0:" + Pattern.matches(regex, source0));
        System.out.println("source1:" + Pattern.matches(regex, source1));
        System.out.println("source2:" + Pattern.matches(regex, source2));
        System.out.println("source3:" + Pattern.matches(regex, source3));
        System.out.println("source4:" + Pattern.matches(regex, source4));
        System.out.println("source5:" + Pattern.matches(regex, source5));
        System.out.println("source6:" + Pattern.matches(regex, source6));
        System.out.println("source7:" + Pattern.matches(regex, source7));
        System.out.println("source8:" + Pattern.matches(regex, source8));
        System.out.println("source9:" + Pattern.matches(regex, source9));

    }
}
