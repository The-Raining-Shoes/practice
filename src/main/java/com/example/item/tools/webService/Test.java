package com.example.item.tools.webService;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author HXM
 * @date 2021年03月23日 10:20
 */
public class Test {

    public static void main(String[] args) {
        String params = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.bsn.ztesoft.com\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <web:getRatableResource soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                        "         <reqVO xsi:type=\"mod:RatableResourceRequDto\" xmlns:mod=\"http://model.balancemgr.bsn.ztesoft.com\">\n" +
                        "            <accNbr xsi:type=\"xsd:string\">17782263622</accNbr>\n" +
                        "            <prodId xsi:type=\"xsd:string\">208511296</prodId>\n" +
                        "            <queryMonth xsi:type=\"xsd:string\">202103</queryMonth>\n" +
                        "         </reqVO>\n" +
                        "      </web:getRatableResource>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";
        String url = "http://136.5.8.30:7788/services/RatableResource?wsdl";
        try {
            System.out.println(getWebServiceData(url, params));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWebServiceData(String url, String params) throws IOException {
        //接受返回报文
        String result = "";
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setDoInput(true);
        //允许对外输出数据
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setDefaultUseCaches(false);
        conn.setRequestProperty("Host", "*********.com");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        conn.setRequestProperty("SOAPAction", "http://*******************Reg");
        conn.setRequestProperty("Content-Length", String.valueOf(params.length()));
        conn.setRequestMethod("POST");
        //定义输出流
        OutputStream output = conn.getOutputStream();
        byte[] b = params.getBytes(StandardCharsets.UTF_8);
        //发送soap请求报文
        output.write(b, 0, b.length);
        output.flush();
        output.close();
        //定义输入流，获取soap报文
        InputStream input = conn.getInputStream();
        //设置编码格式
        result = IOUtils.toString(input, StandardCharsets.UTF_8);
        input.close();
        System.out.println("请求返回报文：" + result);
        return result;
    }

}
