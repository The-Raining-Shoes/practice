package com.example.item.zrExam.sevenBaiDuMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 计算SN
 *
 * @author HXM
 * @date 2020年04月08日 16:24
 */
//java版计算signature签名
public class SnCal {

    public String getSN(String ip, String ak, String sk) throws UnsupportedEncodingException {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("ip", ip);
        paramsMap.put("coor", "bd09ll");
        // AK
        paramsMap.put("ak", ak);
        // 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
        String paramsStr = toQueryString(paramsMap);
        // 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
        String wholeStr = "/location/ip?" + paramsStr + sk;
        // 对上面wholeStr再作utf8编码
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        // 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
        return MD5(tempStr);
    }

    // 对Map内所有value作utf8编码，拼接返回结果
    public String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey()).append("=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8")).append("&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return null;
    }

}
