package com.demo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean ok = true;
    private String msg;
    private Object data;
    private Map<String, Object> map;

    public Result(String msg) {
        this.ok = false;
        this.msg = msg;
    }

}
