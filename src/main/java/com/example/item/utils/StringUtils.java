package com.example.item.utils;

import jodd.util.StringUtil;

/**
 * 字符工具
 *
 * @author MaoHao
 * @date 2020年05月19日 15:32
 */
public class StringUtils extends StringUtil {

    public static String joinWithoutNull(Object[] array, char separator) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return "";
        } else if (array.length == 1) {
            return array[0] == null ? "" : String.valueOf(array[0]);
        } else {
            StringBuilder sb = new StringBuilder(array.length * 16);

            for (int i = 0; i < array.length; ++i) {
                if (i > 0) {
                    sb.append(separator);
                }

                sb.append(array[i] == null ? "" : array[i]);
            }

            return sb.toString();
        }
    }

}
