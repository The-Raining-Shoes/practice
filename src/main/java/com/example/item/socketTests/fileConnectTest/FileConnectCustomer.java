package com.example.item.socketTests.fileConnectTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Socket中文件传输 （客户端）
 */
public class FileConnectCustomer {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("test1.txt"));
        int len;
        byte[] bytes = new byte[1024];
        // 通过bytes循环写入文件数据
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }

}
