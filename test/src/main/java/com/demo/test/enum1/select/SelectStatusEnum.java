package com.demo.test.enum1.select;

/**
 * 当前处理状态枚举
 * @author: lxw
 * @date: 2023-02-24  16:25
 */
public enum SelectStatusEnum {
    REVIEW("1", "评审中"),
    ADOPTED("2", "已采纳"),
    NOADOPTED("3", "未采纳"),
    FINISHED("4", "已完成");
    private String code;
    private String value;

    SelectStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValue(String code) {
        for (SelectStatusEnum statusEnum : SelectStatusEnum.values()) {
            if (statusEnum.getCode().equals(code) ) {
                return statusEnum.getValue();
            }
        }
        return "";
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
