package com.appleyk.DMB17_责任链模式.DM17.model;

import lombok.Data;

/**
 * <p>抽象对象类</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:57 2018-11-6
 */
@Data
public abstract class AbstractObject {

    private Long id;
    private String name;

    public abstract void show();
}
