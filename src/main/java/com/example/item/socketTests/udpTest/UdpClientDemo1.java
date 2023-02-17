package com.example.item.socketTests.udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientDemo1 {

    public static void main(String[] args) throws IOException {
        // 新建一个发送消息的包
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        String msg = "发送测试消息！";
        // 指定发送消息以及目标服务器的端口和IP地址
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("localhost"), 9000);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

}
