package com.example.item.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <b>(PdfUtil)</b>
 * 操作PDF工具类
 *
 * @author Rainy
 * @version 1.0.0
 * @date 2022/6/23
 */
public class PdfUtils {

    /**
     * 默认标题字体
     */
    public static Font DEFAULT_TITLE_FONT;
    /**
     * 默认标题字体
     */
    public static Font DEFAULT_SECOND_TITLE_FONT;
    /**
     * 默认内容设置
     */
    public static Font DEFAULT_CONTENT_FONT;
    /**
     * 行数
     */
    public static final int DEFAULT_COLUMNS = 24;

    static {
        // 默认字体
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DEFAULT_TITLE_FONT = new Font(baseFont, 16, Font.BOLD);
        DEFAULT_SECOND_TITLE_FONT = new Font(baseFont, 9, Font.BOLD);
        DEFAULT_CONTENT_FONT = new Font(baseFont, 9, Font.NORMAL);
    }

    /**
     * 创建默认的PDF模板
     *
     * @return Document
     */
    public static Document newDefaultDocument() {
        return new Document(PageSize.A4.rotate(), -75, -75, 15, 40);
    }

    /**
     * 创建默认长度的table
     *
     * @return PdfPTable
     */
    public static PdfPTable newPdfTable() {
        return new PdfPTable(DEFAULT_COLUMNS);
    }

    /**
     * @param table               行
     * @param content             内容
     * @param font                样式
     * @param horizontalAlignment 水平对齐方式
     * @param verticalAlignment   垂直对齐方式
     * @param fixedHeight         高度
     * @param colspan             所占列数
     * @param border              传0时不显示网格
     */
    public static void addCellToTable(PdfPTable table, Object content, Font font, Integer horizontalAlignment, Integer verticalAlignment, Float fixedHeight, Integer colspan, Integer border) {
        PdfPCell cell;
        if (content instanceof String) {
            cell = new PdfPCell(new Phrase(content.toString(), font));
        } else if (content instanceof PdfPTable) {
            cell = new PdfPCell((PdfPTable) content);
        } else {
            throw new RuntimeException("不支持的添加类型");
        }
        if (fixedHeight != null) {
            cell.setFixedHeight(fixedHeight);
        }
        if (horizontalAlignment != null) {
            cell.setHorizontalAlignment(horizontalAlignment);
        }
        if (verticalAlignment != null) {
            cell.setVerticalAlignment(verticalAlignment);
        }
        if (colspan != null) {
            cell.setColspan(colspan);
        }
        if (border != null) {
            cell.setBorder(border);
        }
        table.addCell(cell);
    }

    /**
     * 将table列表加到document中
     *
     * @param document  Document对象
     * @param tableList table对象列表
     */
    public static void addTableListToDoc(Document document, List<PdfPTable> tableList) {
        if (CollectionUtils.isEmpty(tableList)) {
            return;
        }
        tableList.forEach(table -> {
            try {
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
    }

}
