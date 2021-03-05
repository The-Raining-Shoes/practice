package com.example.item.method;

/**
 * @author HXM
 * @date 2021年03月04日 19:40
 */
public class JumpMath {

    public static void main(String[] args) {
        int ladder = 4;
        int maxJump = 2;
        int i = calculateCount(ladder, maxJump);
        System.out.println(i);
    }

    private static int calculateCount(int ladder, int maxJump) {
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于最大可跳跃数
            for (int i = 1; i <= maxJump; i++) {
                jump += calculateCount(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jump = calculateCount(ladder, ladder);
        }
        return jump;
    }

}
