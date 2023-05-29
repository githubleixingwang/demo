package com.appleyk.DMB15_观察者模式.DM15.标准简易版;

/**
 * <p>观察者接口，就提供了一个discover方法</p>
 *
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:05 2018-11-21
 * @version v0.1.1
 */
public interface IObserver {

    /**
     * <p>发现，具体发现什么，做什么，交由实现的类吧</p>
     */
    void discover();

}
