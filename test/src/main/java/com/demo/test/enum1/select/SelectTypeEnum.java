package com.demo.test.enum1.select;


/**
 * 反馈类型枚举
 */
public enum SelectTypeEnum {
    BUG("1", "功能缺陷"),
    IDEA("2", "产品建议"),
    OTHER("3", "其他");

    private String code;
    private String value;

    SelectTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValue(String code) {
        for (SelectTypeEnum statusEnum : SelectTypeEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
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
