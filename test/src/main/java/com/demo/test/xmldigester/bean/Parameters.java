package com.demo.test.xmldigester.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-06-14  10:43
 */
public class Parameters implements Serializable {
    private String version;
    private String sortPriority;
    private List<String> list = new ArrayList<>();

    private Map<String,String> param = new HashMap<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSortPriority() {
        return sortPriority;
    }

    public void setSortPriority(String sortPriority) {
        this.sortPriority = sortPriority;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void putParam(String key, String value)
    {
        param.put(key, value);
    }

    public String getParam(String key)
    {
        return param.get(key);
    }

    public void addList(String item){
        this.list.add(item);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "version='" + version + '\'' +
                ", sortPriority='" + sortPriority + '\'' +
                ", list=" + list +
                ", param=" + param +
                '}';
    }
}
