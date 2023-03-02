package com.example.item.tools.webService;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 记录WebService一些方法
 *
 * @author MaoHao
 * @date 2021年03月12日 11:06
 */
public class HttpToWebService {

    public static void main(String[] args) throws IOException {
        //第一步：创建服务地址，不是WSDL地址
        URL url = new URL("");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置请求头
        connection.setRequestProperty("content-type", "application/soap+xml;charset=utf-8");
        connection.setRequestProperty("SOAPAction", "application/soap+xml;charset=utf-8");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //第四步：组织SOAP数据，发送请求
        String soapXML = getXML("");
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        //第五步：接收服务端响应，打印（xml格式数据）
        int responseCode = connection.getResponseCode();
        if (200 == responseCode) {//表示服务端响应成功
            StringBuilder sb;
            try (InputStream is = connection.getInputStream(); InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                sb = new StringBuilder();
                String temp;
                while (null != (temp = br.readLine())) {
                    sb.append(temp);
                }
                System.out.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            InputStream is = connection.getErrorStream();    //通过getErrorStream了解错误的详情，因为错误详情也以XML格式返回，因此也可以用JDOM来获取。
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("result.xml")));// 将结果存放的位置
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                bw.write(inputLine);
                bw.newLine();
            }
            bw.close();
            in.close();
        }
        os.close();
    }

    public static String getXML(String phoneNum) {
        System.out.println(phoneNum);
        return "";
    }

}
