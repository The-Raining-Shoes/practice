package com.example.item.likou;

import com.example.item.utils.JsonUtil;

/**
 * <b>(Demo2)</b>
 * 计算两数字倒数相加之和，例：102+105 = 207 ，输出结果应为702 ，（倒过来进10）
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/7/1
 */
public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(9, new ListNode(3, new ListNode(7)));
        System.out.println(JsonUtil.toJson(demo2.addTwoNumbers(listNode1, listNode2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int i) {
        if (l1 == null && l2 == null && i == 0) {
            return null;
        }
        int val = i;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = add(l1, l2, val / 10);
        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


