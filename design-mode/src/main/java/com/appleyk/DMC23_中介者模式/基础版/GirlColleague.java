package com.appleyk.DMC23_中介者模式.基础版;

/**
 * <p>
 *     具体的同事类，Colleague 的具体实现类。
 *     当一个同事类想要调用另一个同事的方法的时候，它必须调用中介者的方法，
 *     中介者中的方法再去调用其他同事的方法。
 *     女同事
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:14:23
 */
public class GirlColleague extends Colleague {

    public GirlColleague(String name,Mediator mediator){
        super(name,mediator);
        /**把自己的信息登记到hr那*/
        getMediator().register(this);
    }

    public void agree(String name) {
        getMediator().contact(this,String.format(
                "%s,你好，我是%s,你就是我好找的人，我们去约会吧！",name,getName()
        ));
    }

    public void degree(String name){
        getMediator().contact(this,String.format(
                "%s,你好，我是%s,我们俩不合适，抱歉！",name,getName()
        ));
    }

    @Override
    public void doReceiveMsg(String name , String message) {
        if (message.contains("高") || message.contains("富") || message.contains("帅")){
            agree(name);
        }else{
            degree(name);
        }
        System.out.println("===========================");
    }
}
