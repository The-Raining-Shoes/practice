package com.example.item.method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * stream类的使用
 *
 * @author HXM
 * @date 2020年05月22日 17:10
 */
public class StreamTest {
    void range() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        System.out.println(Arrays.toString(IntStream.range(0, Math.min(list1.size(), list2.size()))
                .map(i -> list1.get(i) + list2.get(i))
                .boxed().toArray()));
    }
}
