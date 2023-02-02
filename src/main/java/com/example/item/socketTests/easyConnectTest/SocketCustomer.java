package com.example.item.socketTests.easyConnectTest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketCustomer {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress,9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("测试一下socket编程".getBytes());
        socket.close();
        outputStream.close();
    }

}
