package com.example.item.zrExam.nineSplitTest;

import java.util.Stack;

/**
 * 算法题目要求：String expression = "file{(a)222}<xxxxx[bb(cc)]{[ddd](eeee)}>";
 * 1.	解析表达式，不允许通过split所有可能的分隔符来获取数据，必须考虑通用性
 * 2.	获取各种括号里面的内容，括号包括：(){}[]<>
 * 3.	获取了这个表达式中括号的内容后进行排序输出，结果如下：
 * 222
 * a
 * bb
 * cc
 *
 * @author HXM
 * @date 2020年04月09日 14:13
 */
public class HighSplitTest {
    public static void main(String[] args) {
        String expression = "file{12312(a)222}<xxxxx[bb(cc)]{321[ddd](eeee)}>";
        char[] chars = expression.toCharArray();
        Stack<Object> stack = new Stack<>();
        for (char t : chars) {
            switch (t) {
                case '}': {
                    pop(stack, "{");
                    break;
                }
                case '>': {
                    pop(stack, "<");
                    break;
                }
                case ')': {
                    pop(stack, "(");
                    break;
                }
                case ']': {
                    pop(stack, "[");
                    break;
                }
                default: {
                    stack.push(t);
                    break;
                }
            }
        }
    }

    static void pop(Stack<Object> stack, String str) {
        String a = "";
        do {
            System.out.print(a);
        } while (!str.equals(a = stack.pop().toString()));
        if (!"".equals(a)) {
            System.out.println();
        }
    }
}
