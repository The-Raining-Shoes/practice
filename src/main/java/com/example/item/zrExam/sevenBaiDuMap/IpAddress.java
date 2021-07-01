package com.example.item.zrExam.sevenBaiDuMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 百度地图普通IP地址查询
 *
 * @author HXM
 * @date 2020年04月08日 15:01
 */
public class IpAddress {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String ip = "183.67.60.70";
        String ak = "a9VUWWLb0VwVilReL9mo1mPgGDcz9VpG";
        String sk = "aDOMfZZLwDt60on9CnOqxYNRoSOGxDss";
        SnCal snCal = new SnCal();
        String sn = snCal.getSN(ip, ak, sk);
        String r = httpRequest("http://api.map.baidu.com/location/ip?ip=" + ip + "&coor=bd09ll&" +
                               "ak=" + ak + "&sn=" + sn, "GET", null);
        JSONObject jsonObject = JSON.parseObject(r);
        System.err.print(JSON.toJSON(jsonObject));
    }

    //处理http请求  requestUrl为请求地址  requestMethod请求方式，值为"GET"或"POST"
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);
            conn.connect();
            //往服务器端写内容 也就是发起http请求需要带的参数
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes(StandardCharsets.UTF_8));
                os.close();
            }
            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert buffer != null;
        return buffer.toString();
    }

}
