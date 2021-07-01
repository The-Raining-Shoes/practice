package com.example.item.tools.exportExcle;

import com.example.item.utils.CheckUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 导出Excle文件(2007版Excle)
 *
 * @author mh create 2019年11月20日下午17:57:03
 */
@Slf4j
public class ExportExcle2007 {

    public void exportByMould(String filePath, Map<String, String> replaceList, String fileName, List<Object[]> dataList, HttpServletResponse response) {
        InputStream in;
        Workbook wb = null;
        try {

            ClassPathResource classPathResource = new ClassPathResource(filePath);
            in = classPathResource.getInputStream();
            wb = new XSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);
            // 获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            // 获取最大列数
            int colnum = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int i = 0; i < rownum; i++) {
                for (int j = 0; j < colnum; j++) {
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    for (Map.Entry<String, String> it : replaceList.entrySet()) {
                        value = value.replaceAll(it.getKey(), it.getValue());
                    }
                    sheet.getRow(i).getCell(j).setCellValue(value);
                }
            }

            // 表格加边框样式
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            //获取模板列宽
            float width = sheet.getColumnWidthInPixels(sheet.getRow(0).getCell(0).getColumnIndex());
            //获取模板行高
            float height = sheet.getRow(0).getHeightInPoints();

            // 写入数据
            for (int i = 0; i < dataList.size(); i++) {
                Row rows = wb.getSheetAt(0).createRow(2 + i);
                Object[] obj = dataList.get(i);// 遍历每个对象
                //设置行高
                rows.setHeightInPoints(height);
                for (int j = 0; j < obj.length; j++) {
                    // 将内容按顺序赋给对应的列对象
                    Cell cell = rows.createCell(j);
                    cell.setCellValue(String.valueOf(obj[j]));
                    //使用样式
                    cell.setCellStyle(cellStyle);
                    //设置列宽
                    sheet.setDefaultColumnWidth((int) width);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ExportExcle2007 excel = new ExportExcle2007();
        excel.exportExcel(fileName, Objects.requireNonNull(wb), response);
    }

    public void export(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response) {
        this.handleExcle(title, rowName, dataList, response);
    }

    public void donwLoadMouldFile(String fileName, String filePath, HttpServletResponse response) {
        InputStream in;
        Workbook workbook = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource(filePath);
            in = classPathResource.getInputStream();
            XSSFWorkbook wb = new XSSFWorkbook(in);
            workbook = new SXSSFWorkbook(wb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExportExcle2007 excel = new ExportExcle2007();
        excel.exportExcel(fileName, Objects.requireNonNull(workbook), response);
    }

    private void handleExcle(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response) {
        Workbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(title); // 创建工作表
        sheet.setRandomAccessWindowSize(-1);
        // 定义所需列数
        int columnNum = rowName.length;
        Row rowRowName = sheet.createRow(0);
        // 将列头设置到sheet的单元格中
        for (int n = 0; n < columnNum; n++) {
            Cell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
            cellRowName.setCellType(CellType.STRING); // 设置列头单元格的数据类型
            cellRowName.setCellValue(new XSSFRichTextString(rowName[n])); // 设置列头单元格的值
        }
        // 将查询出的数据设置到sheet对应的单元格中
        for (int i = 0; i < dataList.size(); i++) {
            Object[] obj = dataList.get(i);// 遍历每个对象
            Row row = sheet.createRow(i + 1);// 创建所需的行数
            for (int j = 0; j < obj.length; j++) {
                Cell cell = row.createCell(j, CellType.STRING);
                if (CheckUtils.isNotBlank(obj)) {
                    cell.setCellValue(obj[j].toString()); // 设置单元格的值
                } else {
                    cell.setCellValue(""); // 设置单元格的值
                }
            }
        }
        // 让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                Row currentRow;
                // 当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    Cell currentCell = currentRow.getCell(colNum);
                    if (currentCell != null && currentCell.getCellTypeEnum() == CellType.STRING) {
                        if (null != currentCell.getRichStringCellValue()) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
            }
            if (colNum == 0) {
                sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
            } else {
                sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
            }
        }
        this.exportExcel(title, workbook, response);
    }

    private void exportExcel(String fileName, Workbook workbook, HttpServletResponse response) {
        try (OutputStream out = response.getOutputStream()) {
            String name = java.net.URLEncoder.encode(fileName + ".xlsx", StandardCharsets.UTF_8.name());
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
