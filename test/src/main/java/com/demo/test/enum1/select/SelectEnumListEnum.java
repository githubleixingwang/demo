package com.demo.test.enum1.select;

public enum SelectEnumListEnum {
    E01("E01","com.demo.test.enum1.select","type","反馈类型"),
    E02("E02","com.demo.test.enum1.select","status","处理状态");

    private String code;
    private String path;
    private String name;
    private String desc;

    SelectEnumListEnum(){}
    SelectEnumListEnum(String code, String path, String name, String desc){
        this.code = code;
        this.path = path;
        this.name=name;
        this.desc = desc;
    }

    public static SelectEnumListEnum getByCode(String code){
        for(SelectEnumListEnum element : SelectEnumListEnum.values()){
            if(element.getCode().equals(code)) return element;
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
