package com.example.item.auditionParctice.mement;

import java.util.Stack;

/**
 * <b>(History)</b>
 *
 * @author Rainy 2023-01-07 22:56:42
 * @version 1.0.0
 */
public class History {

    static Stack<BackUp> stack = new Stack<>();

    public static void log(BackUp backUp) {
        stack.add(backUp);
    }

    public static BackUp getHis() {
        return stack.pop();
    }

}
