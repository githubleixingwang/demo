package com.demo.test.easyexcel.compare;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 读取两列数据的数据类
 *
 * @author demo
 */
@Getter
@Setter
public class CompareData {
    @ExcelProperty(index = 0)
    private String column1;

    @ExcelProperty(index = 1)
    private String column2;
}
