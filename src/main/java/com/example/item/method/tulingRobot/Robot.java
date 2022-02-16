package com.example.item.method.tulingRobot;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * 图灵机器人实现聊天
 *
 * @author MaoHao
 * @date 2020年11月05日 9:28
 */
public class Robot {

    //机器人对应的APIkey--图灵平台获取
    public static final String API_KEY = "312b785ad17c47c8aa9164ecb6e91e43";
    public static final String API_URL = "http://www.tuling123.com/openapi/api";

    /**
     * @param msg 需要发送的消息
     */
    private String setParameter(String msg) {
        try {
            return API_URL + "?key=" + API_KEY + "&info=" + URLEncoder.encode(msg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 拿到消息回复的内容
     *
     * @param json 请求接口得到的JSON
     * @return text的部分
     */
    private String getString(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 提供对外公开的方法用于最终拿到机器人回复的消息
     *
     * @param msg 传入你需要发送的信息
     * @return 机器人对你的回复
     */
    public String getMessage(String msg) {
        return getString(getHTML(setParameter(msg)));
    }


    private String getHTML(String url) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Robot util = new Robot();
        Scanner scanner = new Scanner(System.in);//控制台输入
        while (scanner.hasNext()) {
            //直接输出机器人的回复
            System.err.println("纯纯的机器人： " + util.getMessage(scanner.nextLine()));
        }
    }

}
