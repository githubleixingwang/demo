package com.demo.test.nodeData.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class AddressSheetData extends ExportSheetData {

    @Excel(name = "资产名称",width = 30.0,orderNum = "1")
    private String assetName;
    @Excel(name = "地址",width = 30.0,orderNum = "2")
    private String addr;

    @Excel(name = "被攻击数",width = 30.0,orderNum = "3")
    private String byAttackCount;

    @Excel(name = "来源",width = 30.0,orderNum = "4")
    private String dataSourceStr;

}
