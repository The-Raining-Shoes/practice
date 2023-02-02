package com.example.item.method;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author 郑光钦
 * @version 1.0.0
 */
public class ZhengMethod {
    static String str = "abcdefghijklmnopqrstuvwxyz0123456789";
    static ArrayList<String> strList = new ArrayList<>();
    static int[] count;

    static {
        int cpuNums = Runtime.getRuntime().availableProcessors() - 6;
        int v = (str.length() % cpuNums == 0) ? (str.length() / cpuNums) : (int) (Math.floor((str.length() / cpuNums)) + 1);
        for (int i = 0; i < cpuNums; i++) {
            int start = i * v;
            if (start + v >= str.length()) {
                strList.add(str.substring(start));
                break;
            } else {
                strList.add(str.substring(start, start + v));
            }
        }
        count = new int[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            count[i] = 0;
        }
    }

    static int x = 5;

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("开始时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime));
        ExecutorService executor = new ThreadPoolExecutor(40, 100, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(16), Executors.defaultThreadFactory());
        CountDownLatch countDownLatch = new CountDownLatch(str.length());
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            final String startStr = String.valueOf(str.charAt(i));
            System.out.println(startStr);
            final int q = i;
            executor.execute(() -> {
                String[] result = new String[x];
                result[0] = startStr;
                count[q] = ddd(result, 0, count[q]);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("结束时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endTime));
        long i = endTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - startTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("花费时间" + i / 1000 + "秒");
        int reduce = Arrays.stream(count).reduce(0, Integer::sum);
        System.out.println("生成字符串个数:" + reduce);

    }

    static int ddd(String[] result, int i, int count) {
        i++;
        for (int m = 0; m < str.length(); m++) {
            String mi = String.valueOf(str.charAt(m));
            result[i] = mi;
            if (i < x - 1) {
                count = ddd(result, i, count);
            } else {
                count++;
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : result) {
                    stringBuilder.append(s);
                }
                System.out.println(Thread.currentThread().getName() + ":" + stringBuilder.toString());
            }
        }

        return count;
    }
}
