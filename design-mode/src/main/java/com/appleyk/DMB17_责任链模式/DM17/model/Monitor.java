package com.appleyk.DMB17_责任链模式.DM17.model;

import lombok.Data;

/**
 * 显示器
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 2:03 2018-11-6
 */
@Data
public class Monitor extends AbstractObject {

    /**尺寸*/
    private Integer size;

    @Override
    public void show() {
        System.out.println("显示器");
    }
}
