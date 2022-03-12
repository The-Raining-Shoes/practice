package com.example.item.thread.function;

import com.example.item.utils.CheckUtil;

import java.util.function.Predicate;

/**
 * predicate类型也是可以重写下面的方法，里面有一个test接口，可以替换成自己的逻辑
 * 断定型接口
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = CheckUtil::isBlank;
        System.out.println(predicate.test(""));
    }

}
