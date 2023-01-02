package com.example.item.method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件分治关系
 * 多文件分离再做对比（快速）
 *
 * @author rainy
 */
public class FileTests {
    static String base = "D:\\工作文档\\测试\\测试文件";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        split();
        System.out.println("文件拆分完成: " + (System.currentTimeMillis() - start));
        Set<Integer> set = new HashSet<>(100);
        for (int i = 0; i < 10; i++) {
            set.addAll(compare("/numbers1-" + i + ".txt", "/numbers2-" + i + ".txt"));
        }
        System.out.println("文件对比完成: " + (System.currentTimeMillis() - start));
        System.out.println(set);
    }


    private static Set<Integer> compare(String file1, String file2) throws IOException {
        Set<Integer> set = new HashSet<>(1000000);
        Set<Integer> set2 = new HashSet<>(1000000);
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(base, file1))
        ) {
            String line = reader.readLine();
            while (line != null) {
                int value = Integer.parseInt(line);
                set.add(value);
                line = reader.readLine();
            }
        }
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(base, file2))
        ) {
            String line = reader.readLine();
            while (line != null) {
                int value = Integer.parseInt(line);
                if (set.contains(value)) {
                    set2.add(value);
                }
                line = reader.readLine();
            }
        }
        return set2;
    }

    private static void split() throws IOException {
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(base, "numbers1.txt"));
                BufferedWriter out0 = new BufferedWriter(new FileWriter(base + "/numbers1-0.txt"));
                BufferedWriter out1 = new BufferedWriter(new FileWriter(base + "/numbers1-1.txt"));
                BufferedWriter out2 = new BufferedWriter(new FileWriter(base + "/numbers1-2.txt"));
                BufferedWriter out3 = new BufferedWriter(new FileWriter(base + "/numbers1-3.txt"));
                BufferedWriter out4 = new BufferedWriter(new FileWriter(base + "/numbers1-4.txt"));
                BufferedWriter out5 = new BufferedWriter(new FileWriter(base + "/numbers1-5.txt"));
                BufferedWriter out6 = new BufferedWriter(new FileWriter(base + "/numbers1-6.txt"));
                BufferedWriter out7 = new BufferedWriter(new FileWriter(base + "/numbers1-7.txt"));
                BufferedWriter out8 = new BufferedWriter(new FileWriter(base + "/numbers1-8.txt"));
                BufferedWriter out9 = new BufferedWriter(new FileWriter(base + "/numbers1-9.txt"))
        ) {
            String line = reader.readLine();
            while (line != null) {
                int value = Integer.parseInt(line);
                switch (value % 10) {
                    case 0:
                        out0.write(line);
                        out0.newLine();
                        break;
                    case 1:
                        out1.write(line);
                        out1.newLine();
                        break;
                    case 2:
                        out2.write(line);
                        out2.newLine();
                        break;
                    case 3:
                        out3.write(line);
                        out3.newLine();
                        break;
                    case 4:
                        out4.write(line);
                        out4.newLine();
                        break;
                    case 5:
                        out5.write(line);
                        out5.newLine();
                        break;
                    case 6:
                        out6.write(line);
                        out6.newLine();
                        break;
                    case 7:
                        out7.write(line);
                        out7.newLine();
                        break;
                    case 8:
                        out8.write(line);
                        out8.newLine();
                        break;
                    case 9:
                        out9.write(line);
                        out9.newLine();
                        break;
                    default:
                        System.out.println("无效的数据");
                }
                line = reader.readLine();
            }
        }

        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(base, "numbers2.txt"));
                BufferedWriter out0 = new BufferedWriter(new FileWriter(base + "/numbers2-0.txt"));
                BufferedWriter out1 = new BufferedWriter(new FileWriter(base + "/numbers2-1.txt"));
                BufferedWriter out2 = new BufferedWriter(new FileWriter(base + "/numbers2-2.txt"));
                BufferedWriter out3 = new BufferedWriter(new FileWriter(base + "/numbers2-3.txt"));
                BufferedWriter out4 = new BufferedWriter(new FileWriter(base + "/numbers2-4.txt"));
                BufferedWriter out5 = new BufferedWriter(new FileWriter(base + "/numbers2-5.txt"));
                BufferedWriter out6 = new BufferedWriter(new FileWriter(base + "/numbers2-6.txt"));
                BufferedWriter out7 = new BufferedWriter(new FileWriter(base + "/numbers2-7.txt"));
                BufferedWriter out8 = new BufferedWriter(new FileWriter(base + "/numbers2-8.txt"));
                BufferedWriter out9 = new BufferedWriter(new FileWriter(base + "/numbers2-9.txt"))
        ) {
            String line = reader.readLine();
            while (line != null) {
                int value = Integer.parseInt(line);
                switch (value % 10) {
                    case 0:
                        out0.write(line);
                        out0.newLine();
                        break;
                    case 1:
                        out1.write(line);
                        out1.newLine();
                        break;
                    case 2:
                        out2.write(line);
                        out2.newLine();
                        break;
                    case 3:
                        out3.write(line);
                        out3.newLine();
                        break;
                    case 4:
                        out4.write(line);
                        out4.newLine();
                        break;
                    case 5:
                        out5.write(line);
                        out5.newLine();
                        break;
                    case 6:
                        out6.write(line);
                        out6.newLine();
                        break;
                    case 7:
                        out7.write(line);
                        out7.newLine();
                        break;
                    case 8:
                        out8.write(line);
                        out8.newLine();
                        break;
                    case 9:
                        out9.write(line);
                        out9.newLine();
                        break;
                    default:
                        System.out.println("无效的数据");
                }
                line = reader.readLine();
            }
        }
    }
}
