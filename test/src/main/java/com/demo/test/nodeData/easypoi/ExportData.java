package com.demo.test.nodeData.easypoi;

import lombok.Data;

import java.util.List;

/**
 * @author: lxw
 * @date: 2023-05-29  10:13
 */
@Data
public class ExportData {

    private String sheetName;
    private List<ExportSheetData> sheetDatas;


}
