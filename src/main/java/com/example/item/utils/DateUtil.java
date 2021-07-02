package com.example.item.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 根据时间戳转格式化时间
     * @param timeStamp 时间戳
     * @param pattern 时间格式
     * @return 格式化时间
     */
    public static String getFormatTimeByTimeStamp(int timeStamp, String pattern) {
        return new SimpleDateFormat(pattern).format(new Date(Long.parseLong(timeStamp + "000")));
    }

    /**
     * 指定时间字符串转时间类型
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return Date
     */
    public static Date getDateByFormatTime(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            // 转化成日期类型
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定日期所在月份开始的时间戳
     *
     * @param date 指定日期
     * @param type 1-某天 2-某月
     * @return Long
     */
    public static Long getTimeStampBegin(Date date, Integer type) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (type == 2) {
            //设置为1号,当前日期既为本月第一天
            c.set(Calendar.DAY_OF_MONTH, 1);
        }
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis();
    }

    /**
     * 获取指定日期所在月份结束的时间戳
     *
     * @param date 指定日期
     * @return Long
     */
    public static Long getTimeStampEnd(Date date, Integer type) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (type == 2) {
            //设置为当月最后一天
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis();
    }

}
