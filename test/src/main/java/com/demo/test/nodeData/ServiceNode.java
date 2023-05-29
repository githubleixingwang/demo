package com.demo.test.nodeData;

public class ServiceNode extends CommonProperty {

    /**
     *【服务名称】
     */
    private String name;
    /**
     *【服务对应的端口】
     */
    private String port;
    /**
     * 【数据来源】
     * asset（资产）
     * monitor（监控）
     */
    private String dataSource;
    // 数据来源对应的中文描述
    private String dataSourceStr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSourceStr() {
        return dataSourceStr;
    }

    public void setDataSourceStr(String dataSourceStr) {
        this.dataSourceStr = dataSourceStr;
    }
}
