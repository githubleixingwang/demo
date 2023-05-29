package com.appleyk.DMA1_工厂方法.F1;

import com.appleyk.DMA1_工厂方法.DM1.IChat;
import com.appleyk.DMA1_工厂方法.DM1.QQ;
import com.appleyk.DMA1_工厂方法.DM1.WeiXin;

/**
 * <p>单方法工厂模式</p>
 *
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 上午 10:25 2018-11-6
 * @version v0.1.1
 */
public class ChatFactory1 {
    public IChat createChat(String tools){
        if("QQ".equals(tools)){
            return new QQ();
        }else if("WeiXin".equals(tools)) {
            return new WeiXin();
        }else{
            return null;
        }
    }
}
