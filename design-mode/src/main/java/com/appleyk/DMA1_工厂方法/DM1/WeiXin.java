package com.appleyk.DMA1_工厂方法.DM1;

/**
 * <p>微信社交App实现聊天接口</p>
 *
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 上午 10:25 2018-11-6
 * @version v0.1.1
 */
public class WeiXin implements IChat {
    @Override
    public void chatting(String seqNo) {
        System.out.println("使用微信进行聊天 -- " + seqNo);
    }
}
