package com.appleyk.DMA3_单例模式.DM3;

/**
 * <p>枚举类</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/23:20:11
 */
public enum Singleton6 {
    INSTANCE;
    public void show(){
        System.out.println("你好，我是单例模式六！");
    }

    public static void main(String[] args) {
        Singleton6.INSTANCE.show();
    }
}
