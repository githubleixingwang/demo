package com.demo.test.easypoi.data.sheet;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author: lxw
 * @date: 2023-05-29  10:14
 */
@Data
public class CommonSheetData {

    /**
     * 首次出现的时间，格式为：yyyy-MM-dd HH:mm:ss
     */
    @Excel(name = "首次时间",width = 30.0,orderNum = "10")

    private String firstTime;

    /**
     * 最后出现的时间，格式为：yyyy-MM-dd HH:mm:ss
     */
    @Excel(name = "末次时间",width = 30.0,orderNum = "11")

    private String endTime;

}
