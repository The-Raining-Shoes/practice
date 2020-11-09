package com.example.item.method.fetchLineData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HXM
 * @date 2020年09月29日 16:10
 */
public class FetchLineData {
    public static void main(String[] args) throws IOException {
        List<String> orderIds = Files.lines(Paths.get("D:/12.txt")).collect(Collectors.toList());
//        List<String> orderIds = Files.readAllLines(Paths.get("D:/数据.dat"));
        for (String str : orderIds) {
            System.out.println(str);
        }
    }
}
