package com.appleyk.DMA10_桥接模式.DM10.paint.shape;

/**
 * <p>正方形</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:05 2018-11-19
 */
public class Square extends AbstractShape {
    @Override
    public void draw() {
        getColor().painting("正方形");
    }
}
