package com.example.item.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@HeadRowHeight(20)    // 表头行高
@ColumnWidth(15)
public class StaffUploadMouldFileDTO {

    @ExcelProperty(value = "姓名", index = 0)
    private String externalId;

    @ExcelProperty(value = "别名", index = 1)
    private String name;

    @ExcelProperty(value = "职务", index = 2)
    private String position;

    @ExcelProperty(value = "部门", index = 3)
    private String department;

    @ExcelProperty(value = "性别", index = 4)
    private String gender;

    @ExcelProperty(value = "手机", index = 5)
    private String mobile;

    @ExcelProperty(value = "座机", index = 6)
    private String telephone;

    @ExcelProperty(value = "个人邮箱", index = 7)
    private String mail;

    @ExcelProperty(value = "地址", index = 8)
    private String address;

    @ExcelProperty(value = "企业简称", index = 9)
    private String externalCorpName;

}
