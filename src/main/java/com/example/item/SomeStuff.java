package com.example.item;

import com.spire.xls.FileFormat;
import com.spire.xls.InsertOptionsType;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16);
        map.put("#test#", "啊啊啊啊啊啊啊啊");
        map.put("#tests#", "谢谢了喜啊啊啊");
        Workbook wb = new Workbook();
        try {
            ClassPathResource classPathResource = new ClassPathResource("/templates/test.xls");
            // 加载文件
            wb.loadFromFile(classPathResource.getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Worksheet worksheet = wb.getWorksheets().get(0);
        int row = worksheet.getRows().length;
        int columns = worksheet.getColumns().length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < columns; j++) {
                String value = worksheet.get(i, j).getValue();
                for (Map.Entry<String, String> it : map.entrySet()) {
                    value = value.replaceAll(it.getKey(), it.getValue());
                }
                worksheet.setCellValue(i, j, value);
            }
        }
        // 从多少行开始插入表格
        worksheet.insertRow(22, 1, InsertOptionsType.FormatAsBefore);
        for (int i = 22; i < 23; i++) {
            for (int j = 1; j < 7; j++) {
                worksheet.setCellValue(i, j, "test");
            }
        }
        worksheet.getCellRange(22, 1).getStyle().getFont().isBold(false);
        try {
            wb.saveToFile("tests.pdf", FileFormat.PDF);
        } catch (Exception ignore) {
        } finally {
            delFile("tests.pdf");
        }
    }

    public static void delFile(String filePathAndName) {
        try {
            File myDelFile = new File(filePathAndName);
            boolean delete = myDelFile.delete();
            if (!delete) {
                System.out.println("删除文件错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}