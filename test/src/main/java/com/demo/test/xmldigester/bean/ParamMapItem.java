package com.demo.test.xmldigester.bean;

/**
 * @author: lxw
 * @date: 2023-10-19  18:01
 */
public class ParamMapItem   {
    private String key;
    private String des;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParamMapItem{" +
                "key='" + key + '\'' +
                ", des='" + des + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
