package com.demo.test.nodeData;

import lombok.Data;

@Data
public class AddressNode extends CommonProperty {


    private String addr;

    private String dataSource;
    // 数据来源对应的中文描述
    private String dataSourceStr;


    private String assetName;

    private String byAttackCount;

}
