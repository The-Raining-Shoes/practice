package com.example.item.zrExam.tenFileReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 多线程合并文件
 *
 * @author HXM
 * @date 2020年04月09日 14:40
 */
public class FileReadAndWrite extends Thread {

    private final File file;

    public FileReadAndWrite(File file) {
        this.file = file;
    }

    public static void main(String[] args) throws InterruptedException {
        File[] listFiles = new File("D:\\javaExam").listFiles();
        assert listFiles != null;
        for (File listFile : listFiles) {
            FileReadAndWrite a1 = new FileReadAndWrite(listFile);
            a1.start();
            a1.join();
        }
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            System.out.println(Thread.currentThread().getName());
            in = new FileInputStream(file);
            byte[] b = new byte[in.available()];
//            int length = 0;
            out = new FileOutputStream("D:\\javaExam\\marge.txt", true);
            while (in.read(b) != -1) {
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
