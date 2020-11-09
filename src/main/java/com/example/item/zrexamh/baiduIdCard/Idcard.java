package com.example.item.zrexamh.baiduIdCard;

import java.net.URLEncoder;

/**
 * @author HXM
 * @date 2020年10月23日 14:44
 */
public class Idcard {

    public static void idcard() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        try {
            // 本地文件路径
            String filePath = "D:/测试身份证.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "id_card_side=" + "front" + "&image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = GetAuth.getAuth("g3SzkATCmevbcSD2z6PSjGlW", "mEkOyghm6DkR0WGeysmkXN9R4KMhBd1o ");

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Idcard.idcard();
    }
}
