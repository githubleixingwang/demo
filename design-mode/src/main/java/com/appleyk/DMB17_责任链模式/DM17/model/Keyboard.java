package com.appleyk.DMB17_责任链模式.DM17.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 键盘
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 2:02 2018-11-6
 */
@Data
@AllArgsConstructor
public class Keyboard extends AbstractObject {

    /**
     * 键盘类型
     */
    private String type;


    @Override
    public void show() {
        System.out.println("键盘");
    }
}
