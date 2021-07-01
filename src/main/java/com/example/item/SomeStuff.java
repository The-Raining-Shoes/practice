package com.example.item;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        float f[][] = new float[6][6];
        System.out.println(Arrays.deepToString(f));
    }

}