package com.example.item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        classOne.start();
        ClassTwo classTwo = new ClassTwo();
        classTwo.start();
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class TestDTO {
        private Integer a;
        private Integer b;
    }

}