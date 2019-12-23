package com.example.item.tools.exportExcle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import com.example.item.tools.checkPackage.CheckUtil;
import org.apache.poi.ss.usermodel.Row;

import lombok.extern.slf4j.Slf4j;

/**
 * 导出Excle文件(2007版Excle)
 *
 * @author mh create 2019年11月20日下午17:57:03
 */
@Slf4j
public class ExportExcle2007 {

    public final static String COST_MOULD_FILE = "templates/costMouldFile.xlsx";
    public final static String BATCH_ADD_EMP_TEMPLATE = "templates/batchAddEmpTemplate.xlsx";

    public void export(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response) {
        this.handleExcle(title, rowName, dataList, response);
        log.info("");
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
        Sheet sheet = workbook.createSheet(title); // 创建工作表
        // 定义所需列数
        int columnNum = rowName.length;
        Row rowRowName = sheet.createRow(0);
        // 将列头设置到sheet的单元格中
        for (int n = 0; n < columnNum; n++) {
            Cell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
            cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 设置列头单元格的数据类型
            cellRowName.setCellValue(new XSSFRichTextString(rowName[n])); // 设置列头单元格的值
        }
        // 将查询出的数据设置到sheet对应的单元格中
        for (int i = 0; i < dataList.size(); i++) {
            Object[] obj = dataList.get(i);// 遍历每个对象
            Row row = sheet.createRow(i + 1);// 创建所需的行数
            for (int j = 0; j < obj.length; j++) {
                Cell cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                if (CheckUtil.isNotBlank(obj)) {
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
                    if (currentCell != null && currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
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
