package com.appleyk.DMB18_命令模式.DM18.开关灯;

/**
 * <p>卧室，相当于CMD模式中的【receiver】</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  15:45 2021/10/29
 */
public class Bedroom {
    public void on(){
        System.out.println("卧室灯开！");
    }
    public void off(){
        System.out.println("卧室灯关！");
    }
}
