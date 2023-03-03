package com.demo.test.enum1.select;

import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-02-24  16:59
 */
public class SelectEnumVo {
    private String code;
    private String name;
    private String desc;
    private List<Map<String,String>> options;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Map<String, String>> getOptions() {
        return options;
    }

    public void setOptions(List<Map<String, String>> options) {
        this.options = options;
    }
}
