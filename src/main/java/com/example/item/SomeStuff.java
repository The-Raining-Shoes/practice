package com.example.item;

import com.example.item.utils.PdfUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) {
        try {
            Document document = PdfUtils.newDefaultDocument();
            OutputStream outputStream = new FileOutputStream("D:\\qwer.pdf");
            PdfWriter.getInstance(document, outputStream);
            document.open();
            // 2. 打开document
            PdfPTable titleTable1 = PdfUtils.newPdfTable();
            PdfUtils.addCellToTable(titleTable1, "1231312313132131", PdfUtils.DEFAULT_TITLE_FONT, PdfPCell.ALIGN_CENTER, PdfPCell.ALIGN_MIDDLE, 50f, 14, null);
            PdfPCell nCell;
            PdfPTable nestedTable = new PdfPTable(2);
            PdfPTable nestedTable1 = new PdfPTable(2);
            PdfPCell ncCell;
            ncCell = new PdfPCell(new Paragraph("123"));
            ncCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            ncCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            ncCell.setFixedHeight(25f);
            nestedTable1.addCell(ncCell);
            ncCell = new PdfPCell(new Paragraph("321"));
            ncCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            ncCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            ncCell.setFixedHeight(25f);
            nestedTable1.addCell(ncCell);
            nCell = new PdfPCell(nestedTable1);
            nCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            nCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            nCell.setFixedHeight(25f);
            nCell.setColspan(2);
            nestedTable.addCell(nCell);
            nCell = new PdfPCell(new Paragraph("3"));
            nCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            nCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            nCell.setFixedHeight(25f);
            nestedTable.addCell(nCell);
            nCell = new PdfPCell(new Paragraph("4"));
            nCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            nCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            nCell.setFixedHeight(25f);
            nestedTable.addCell(nCell);
            PdfPCell cell = new PdfPCell(nestedTable);
            cell.setColspan(10);
            cell.setPadding(0);
            titleTable1.addCell(cell);
            document.add(titleTable1);
            // 4. 关闭 (如果未关闭则会生成无效的pdf文件)
            document.close();
        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}