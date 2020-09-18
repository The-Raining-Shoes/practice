package com.example.item.zrexamh.baiduVoice;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author HXM
 * @date 2020年09月16日 8:59
 */
public class VoiceTest {

    public static void main(String[] args) {
        AipSpeech aipSpeech = new AipSpeech("22663684", "qNjT2q0eGM2osuqWbpwuyQhP", "3i6oOP6w8dEqNUTn0fWQ3MoEDW9UDNQ4");
        HashMap<String, Object> options = new HashMap<>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse ttsResponse = aipSpeech.synthesis("测试一下百度的语音呢亲", "zh", 1, options);
        byte[] aa = ttsResponse.getData();
        getFile(aa, "D:/", "1.mp3");
        System.out.println(JSON.toJSONString(ttsResponse));
    }

    public static void getFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                System.out.println(dir.mkdirs());
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
