package com.example.item.socketTests.udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP实现消息传输的简单Demo实现!
 */
public class UdpServerDemo1 {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(9000);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(datagramPacket.getAddress());
        System.out.println(datagramPacket.getSocketAddress());
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
    }

}
