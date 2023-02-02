package com.example.item.socketTests.easyConnectTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(9999);
        // 服务端创建socket连接的时候会对代码进行阻塞
        Socket acceptSocket = socketServer.accept();
        InputStream inputStream = acceptSocket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        int len;
//        byte[] bytes = new byte[1024];
//        while ((len=inputStream.read(bytes))!=-1){
//            String msg = new String(bytes,0,len);
//            System.out.println(msg);
//        }
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());
        socketServer.close();
        acceptSocket.close();
        inputStream.close();
        byteArrayOutputStream.close();
    }

}
