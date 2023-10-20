package com.demo.test.xmldigester.bean;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-10-19  17:57
 */
public class ParamMap   {

    private Map<String, Map<String,String>> map = new HashMap<>();

    public void addMap(ParamMapItem item) {
        HashMap<String, String> map1 = Maps.newHashMap();
        map1.put(item.getKey(),item.getValue());
        map.put(item.getDes(), map1);
    }
    public Map<String, Map<String, String>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, String>> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ParamMap{" +
                "map=" + map +
                '}';
    }
}
