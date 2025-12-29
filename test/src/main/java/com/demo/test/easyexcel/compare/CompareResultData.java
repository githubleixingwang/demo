package com.demo.test.easyexcel.compare;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 写入对比结果的数据类（五列）
 *
 * @author demo
 */
@Getter
@Setter
public class CompareResultData {
    @ExcelProperty(index = 0)
    private String column1;

    @ExcelProperty(index = 1)
    private String column2;

    @ExcelProperty("相同数据")
    private String sameData;

    @ExcelProperty("差异数据1")
    private String diffData1;

    @ExcelProperty("差异数据2")
    private String diffData2;
}
