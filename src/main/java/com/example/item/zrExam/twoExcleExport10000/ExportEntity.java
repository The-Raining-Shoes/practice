package com.example.item.zrExam.twoExcleExport10000;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Message
 * @Author: HXM
 * @Date: 2020/4/7 15:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExportEntity extends BaseRowModel {

    @ExcelProperty(value = "ID", index = 0)
    private int id;

}
