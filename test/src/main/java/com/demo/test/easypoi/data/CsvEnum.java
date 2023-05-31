package com.demo.test.easypoi.data;

public enum CsvEnum {
    ADDRESS("Address", "资产名称,地址,被攻击数,来源,首次时间,末次时间", "资产"),
    SERVICE("Service", "服务名称,端口,来源,首次时间,末次时间", "开放服务");

    String type;
    String header;
    String fileName;

    CsvEnum(String type, String header, String fileName) {
        this.type = type;
        this.header = header;
        this.fileName = fileName;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static String getHeader(String type) {
        for (CsvEnum csvEnum : CsvEnum.values()) {
            if (type.equals(csvEnum.getType())) {
                return csvEnum.getHeader();
            }
        }
        return "";
    }

    public static String getFileName(String type) {
        for (CsvEnum csvEnum : CsvEnum.values()) {
            if (type.equals(csvEnum.getType())) {
                return csvEnum.getFileName();
            }
        }
        return "";
    }
}
