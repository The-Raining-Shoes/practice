package com.example.item;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress);
        InetAddress iNetAddress2 = InetAddress.getByName("www.baidu.com");
        System.out.println(iNetAddress2);
    }

}