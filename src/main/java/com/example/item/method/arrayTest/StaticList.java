package com.example.item.method.arrayTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 初始化列表：正确排序(1,1,2,3,3,5,7,8)
 *
 * @author HXM
 * @date 2020年05月22日 14:30
 */
public class StaticList {
    static List<Integer> getList = Stream.of(1, 3, 3, 5, 1, 7, 8, 2).collect(Collectors.toList());
}
