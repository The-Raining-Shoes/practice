package com.example.item.method;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BetweenDateMethod {

    /**
     * 获取两个日期字符串之间的日期集合
     *
     * @param startTime:yyyyMMdd
     * @param endTime:yyyyMMdd
     * @return list:yyyy-MM-dd
     */
    public static List<Integer> getDateBetweenList(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 声明保存日期集合
        List<Integer> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(Integer.valueOf(sdf.format(startDate)));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取两个日期之间所有的月份集合
     *
     * @param startTime:yyyyMM
     * @param endTime:yyyyMM
     * @return list:yyyyMM
     */
    public static List<Integer> getMonthBetweenList(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        // 声明保存日期集合
        List<Integer> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(Integer.valueOf(sdf.format(startDate)));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.MONTH, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

}
