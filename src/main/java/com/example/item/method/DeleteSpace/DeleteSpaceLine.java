package com.example.item.method.DeleteSpace;

import java.io.*;

/**
 * 遍历一个指定文件夹，把里面所有文件内容空行(也可以自定义，修改部分逻辑)去掉功能
 *
 * @author MaoHao
 * @date 2020年07月09日 16:39
 */
public class DeleteSpaceLine {

    public static void main(String[] args) {
//        String scanfPath = "D:/weixin-work-new/manager-api/src/main/java";
//        String scanfPath = "D:/weixin-work-new/database-entity/src/main/java";
//        String scanfPath = "D:/weixin-work-new/open-api/src/main/java";
//        String scanfPath = "D:/weixin-work-new/manager-webapp/src/pages";
//        String scanfPath = "D:/weixin-work-new-noMove/weixin-receive-web/src/main/java";
        String scanfPath = "D:/JavaSpace/wx-hei-work/webapp/src/pages/TaskCenter";
        scanfFile(scanfPath);
    }

    public String dealFileContent(String filePath) {
        BufferedReader br = null;
        String line;
        StringBuilder bufAll = new StringBuilder(); //保存修改过后的所有内容，不断增加
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (line.equals("") || line.contains("/**") || line.contains("*") || line.contains("*/") || line.contains("//")) {
                    System.out.println("空格不处理");
                } else {
                    bufAll.append(line).append("\r\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bufAll.toString();
    }

    //写回文件
    public void writeFile(String filePath, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读文件总行数方法
//    public static void main(String[] args) {
//        try {
//            File file = new File("D:/test.txt");
//            if (file.exists()) {
//                FileReader fr = new FileReader(file);
//                LineNumberReader lnr = new LineNumberReader(fr);
//
//                int linenumber = 0;
//                while (lnr.readLine() != null) {
//                    linenumber++;
//                }
//                System.out.println("Total number of lines : " + linenumber);
//                lnr.close();
//            } else {
//                System.out.println("File does not exists!");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static void scanfFile(String scanfPath) {
        String filePath1 = "D:/20230109.txt";
        // 递归循环取所有文件
        File file = new File(scanfPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        scanfFile(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        DeleteSpaceLine processData = new DeleteSpaceLine();
                        processData.writeFile(filePath1, processData.dealFileContent(file2.getAbsolutePath()));
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

}
