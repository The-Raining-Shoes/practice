package com.example.item.messageRobot;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class handleRobot {

    /**
     * 组装 发送的信息
     *
     * @param isAt       是否需要 @所有人
     * @param msgContent 要发送信息的主体
     * @param telList    要 @人的电话号码,如果@单独的几个人，就传一个空list，而不是 null
     */
    public static String setMessage(boolean isAt, String msgContent, List<String> telList) {

        TextRebootModel model = new TextRebootModel();
        AtMobiles atMobiles = new AtMobiles();
        atMobiles.setIsAtAll(isAt);
        atMobiles.setAtMobiles(telList);

        ContentModel contentModel = new ContentModel();
        contentModel.setContent(msgContent);

        model.setAt(atMobiles);
        model.setText(contentModel);

        return JSON.toJSONString(model);
    }

    /**
     * 组装 发送的信息
     *
     * @param isAt       是否需要 @所有人
     * @param title      标题
     * @param msgContent 要发送信息的主体
     * @param telList    要 @人的电话号码,如果@单独的几个人，就传一个空list，而不是 null
     */
    public static String setMarkDown(boolean isAt, String title, String msgContent, List<String> telList) {

        MarkDownRebootModel model = new MarkDownRebootModel();
        AtMobiles atMobiles = new AtMobiles();
        atMobiles.setIsAtAll(isAt);
        atMobiles.setAtMobiles(telList);

        MarkDownModel markDownModel = new MarkDownModel();
        markDownModel.setTitle(title);
        markDownModel.setText(msgContent);

        model.setAt(atMobiles);
        model.setMarkdown(markDownModel);

        return JSON.toJSONString(model);
    }

    /**
     * post 请求，发送给哪一个机器人
     *
     * @param reboot  机器人的token
     * @param message 发送的消息
     */
    public static String sendPost(String reboot, String message) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(reboot);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        StringEntity se = new StringEntity(message, "utf-8");
        httppost.setEntity(se);
        String result = null;
        CloseableHttpResponse response;
        try {
            response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 查错机器人
     * @param message 封装的消息
     */
    public static void sendErrorReboot(String message) {
        String a = sendPost("https://oapi.dingtalk.com/robot/send?access_token=988c8bd7273f2011f9a65a7cc563c1ec4412299039899c419c6a0d0fca7e3c18", message);
        System.out.println(a);
    }

    public static void main(String[] args) {
        String text=setMessage(false,"hr-我就是我,  @1825718XXXX 是不一样的烟火", Collections.singletonList("17782263622"));
//        String text=setMarkDown(true,"杭州天气","#### 杭州天气  \n > 9度，@1825718XXXX 西北风1级，空气良89，相对温度73%\n\n > ![screenshot](http://i01.lw.aliimg.com/media/lALPBbCc1ZhJGIvNAkzNBLA_1200_588.png)\n  > ###### 10点20分发布 [天气](http://www.thinkpage.cn/)",Arrays.asList(""));
        try {
            sendErrorReboot(text);
        }catch (Exception e){
            System.out.println("报错");
        }
    }
}

@Data
class TextRebootModel {
    /**
     * 此消息类型为固定text
     */
    public String msgtype = "text";

    public ContentModel text;

    public AtMobiles at;
}

@Data
class ContentModel {
    /**
     * 消息内容
     */
    private String content;
}

@Data
class AtMobiles {

    /**
     * 被@人的手机号
     */
    private List<String> atMobiles;

    /**
     * @ 所有人时:true,否则为:false
     */
    private Boolean isAtAll;
}

@Data
class MarkDownRebootModel {
    /**
     * 此消息类型为固定markdown
     */
    public String msgtype = "markdown";

    public MarkDownModel markdown;

    public AtMobiles at;
}

@Data
class MarkDownModel {
    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;
}

