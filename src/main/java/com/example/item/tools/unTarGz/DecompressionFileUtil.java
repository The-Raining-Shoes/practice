package com.example.item.tools.unTarGz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

public class DecompressionFileUtil {
	
	/**
     * 解压tar.gz 文件
     *
     * @param file      要解压的tar.gz文件对象
     * @param outputDir 要解压到某个指定的目录下
     * @throws IOException 解压异常
     */
	public static void unTarGz(File file, String outputDir) throws IOException {
        try (TarInputStream tarIn = new TarInputStream(
            new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))), 1024 * 2)) {
            //创建输出目录
            createDirectory(outputDir, null);
            TarEntry entry;
            while ((entry = tarIn.getNextEntry()) != null) {
                if (entry.isDirectory()) {//是目录
                    createDirectory(outputDir, entry.getName());//创建空目录
                } else {//是文件
                    File tmpFile = new File(outputDir + "/" + entry.getName());
                    createDirectory(tmpFile.getParent() + "/", null);//创建输出目录
                    try (OutputStream out = new FileOutputStream(tmpFile)) {
                        int length;
                        byte[] b = new byte[2048];
                        while ((length = tarIn.read(b)) != -1) {
                            out.write(b, 0, length);
                        }
                    }
                }
            }
        }
    }
	
	 /**
     * 构建目录
     *
     * @param outputDir 输出目录
     * @param subDir    输出子目录
     */
    public static void createDirectory(String outputDir, String subDir) throws IOException {
        File file = new File(outputDir);
        if (!(subDir == null || subDir.trim().equals(""))) {//子目录不为空
            file = new File(outputDir + "/" + subDir);
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    throw new IOException("文件父目录创建失败");
                }
            }
            if (!file.mkdirs()) {
                throw new IOException("文件目录创建失败");
            }
        }
    }
    
}
