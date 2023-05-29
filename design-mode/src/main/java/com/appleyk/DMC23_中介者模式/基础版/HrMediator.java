package com.appleyk.DMC23_中介者模式.基础版;

/**
 * <p>人事中介者，负者联络公司男女同事之间的情愫</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:14:54
 */
public class HrMediator extends Mediator{

    @Override
    public void contact(Colleague colleague, String message) {
        this.getColleagues().forEach(col->{
            if (colleague != col){
                if (colleague instanceof BoyColleague && col instanceof GirlColleague){
                    /** 男同事发给女同事 */
                    col.receiveMsg(colleague.getName(),message);
                }
                if (colleague instanceof GirlColleague && col instanceof BoyColleague){
                    if (message.contains(col.getName())){
                        /** 女同事匹配男同事 */
                        col.receiveMsg(colleague.getName(),message);
                    }
                }
            }
        });
    }
}
