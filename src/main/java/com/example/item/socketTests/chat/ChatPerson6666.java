package com.example.item.socketTests.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatPerson6666 {


    public static void main(String[] args) {
        // 接受消息线程
        new Thread(() -> {
            while (true) {
                try (DatagramSocket datagramSocket = new DatagramSocket(6666)) {
                    byte[] bytes = new byte[1024];
                    DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
                    datagramSocket.receive(datagramPacket);
                    System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "6666接收消息线程").start();
        // 发送消息线程
        new Thread(() -> {
            while (true) {
                try (DatagramSocket datagramSocket = new DatagramSocket()) {
                    // 1.发送消息
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String s = bufferedReader.readLine();
                    DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), 0, s.getBytes().length, InetAddress.getByName("localhost"), 9999);
                    datagramSocket.send(datagramPacket);
                    if (s.equals("再见")) {
                        datagramSocket.close();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "6666发送消息线程").start();
    }

}
