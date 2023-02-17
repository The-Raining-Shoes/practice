package com.example.item.socketTests.fileConnectTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket文件传输（服务端）
 */
public class FileConnectServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.err.println("启动完毕，等待文件上传！");
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("testMan.txt"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        accept.shutdownInput();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }

}
