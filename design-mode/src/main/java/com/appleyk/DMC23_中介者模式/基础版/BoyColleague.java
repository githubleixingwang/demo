package com.appleyk.DMC23_中介者模式.基础版;

/**
 * <p>
 *     具体的同事类，Colleague 的具体实现类。
 *     当一个同事类想要调用另一个同事的方法的时候，它必须调用中介者的方法，
 *     中介者中的方法再去调用其他同事的方法。
 *     男同事
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:14:23
 */
public class BoyColleague extends Colleague {

    public BoyColleague(String name){
        this.setName(name);
    }

    public BoyColleague(String name,Mediator mediator){
        super(name,mediator);
        /**把自己的信息登记到hr那*/
        getMediator().register(this);
    }
    /**发出约会信息*/
    public void engagement (String content) {
        getMediator().contact(new BoyColleague(getName()),content);
    }

    @Override
    public void doReceiveMsg(String name ,String message) {
        /**do nothing*/
    }
}
