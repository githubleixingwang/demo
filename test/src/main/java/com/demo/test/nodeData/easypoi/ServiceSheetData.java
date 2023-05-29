package com.demo.test.nodeData.easypoi;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class ServiceSheetData extends ExportSheetData {

    @Excel(name = "服务名称", width = 30.0, orderNum = "1")
    private String name;

    @Excel(name = "端口", width = 30.0, orderNum = "2")
    private String port;

    @Excel(name = "来源", width = 30.0, orderNum = "1")
    private String dataSourceStr;
}
