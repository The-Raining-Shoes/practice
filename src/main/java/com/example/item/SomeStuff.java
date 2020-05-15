package com.example.item;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author HXM
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {
    public static void main(String[] args) {
        File file = new File("D:\\测试.xlsx");
        Workbook workbook;
        try {
            InputStream in = new FileInputStream(file);
            workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.createSheet();
            Row row = sheet.createRow(1);
            Cell cell = row.createCell(1);
            cell.setCellValue("测试数据");
            OutputStream out = new FileOutputStream("D:\\测试.xlsx");
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}