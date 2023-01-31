package com.example.item.method.foreachZip;

import com.alibaba.excel.EasyExcel;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * 循环解压
 *
 * @author HXM
 * @date 2021年03月05日 9:56
 */
public class DoJob {

    private static byte[] ZIP_HEADER_1 = new byte[]{80, 75, 3, 4};
    private static byte[] ZIP_HEADER_2 = new byte[]{80, 75, 5, 6};

    public static void main(String[] args) {
        String path = "D:/hhjl";
        scanDirectory(path);
    }

    public static void scanDirectory(String directory) {
        File originFile = new File(directory);
        if (originFile.exists()) {
            File[] files = originFile.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file : files) {
                    // 如为压缩文件单独处理
                    if (isArchiveFile(file)) {
                        readFile(file.getAbsolutePath());
                    }
                    // 文件夹递归处理
                    else if (file.isDirectory()) {
                        scanDirectory(file.getAbsolutePath());
                    }
                    // 如为目标xlsx文件直接处理
                    else if (file.getName().endsWith("xlsx")) {
                        try {
                            List<BaseDTO> list = EasyExcel.read(new FileInputStream(file), BaseDTO.class, null).sheet().doReadSync();
                            for (BaseDTO dto : list) {
                                System.out.println("当前处理文件" + file.getAbsolutePath() + "————" + dto);
                            }
                        } catch (Exception ignore) {
                        }

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    /**
     * 读取文件操作，传入压缩包名称
     */
    public static void readFile(String fileName) {
        InputStream in;
        try {
            ZipFile zf = new ZipFile(fileName);
            in = new BufferedInputStream(new FileInputStream(fileName));
            Charset gbk = Charset.forName("gbk");
            ZipInputStream zin = new ZipInputStream(in, gbk);
            ZipEntry ze;
            while ((ze = zin.getNextEntry()) != null) {
                if (ze.toString().endsWith("xlsx")) {
                    List<BaseDTO> list = EasyExcel.read(zf.getInputStream(ze), BaseDTO.class, null).sheet().doReadSync();
                    for (BaseDTO dto : list) {
                        System.out.println("当前处理文件" + fileName + "————" + dto);
                    }
                }
            }
            zin.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断文件是否为一个压缩文件
     */
    public static boolean isArchiveFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return false;
        }
        boolean isArchive = false;
        try (InputStream input = new FileInputStream(file)) {
            byte[] buffer = new byte[4];
            int length = input.read(buffer, 0, 4);
            if (length == 4) {
                isArchive = (Arrays.equals(ZIP_HEADER_1, buffer)) || (Arrays.equals(ZIP_HEADER_2, buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isArchive;
    }

}
