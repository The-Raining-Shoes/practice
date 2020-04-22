package com.example.item.zrexamh.twoExcleExport10000;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.example.item.config.JdbcConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Message
 * @Author: HXM
 * @Date: 2020/4/7 10:04
 */
public class ExcleExport10000 {

    public static void main(String[] args) {
        final String filePath = "D:\\testss.xlsx";
        JdbcTemplate jdbc = new JdbcTemplate(JdbcConfig.getMysql3306ResHJDs(1));
        String querySql = "select id from t_order_detail order by id ";
        List<Map<String, Object>> mapList = jdbc.queryForList(querySql);
        List<ExportEntity> list = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            ExportEntity exportEntity = new ExportEntity();
            exportEntity.setId(Integer.parseInt(map.get("id").toString()));
            list.add(exportEntity);
        }
        OutputStream out;
        try {
            out = new FileOutputStream(filePath);
            ExcelWriter writer = EasyExcelFactory.getWriter(out);
            Sheet sheet1 = new Sheet(1, 0, ExportEntity.class);
            sheet1.setSheetName("第一个sheet");
            writer.write(list, sheet1);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
