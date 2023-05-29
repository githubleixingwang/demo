package com.appleyk.DMC23_中介者模式.基础版;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>抽象中介者角色，主要定义一个接口，用于各个同事之间进行互相通信。与同事类相互依赖。</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:14:20
 */
public abstract class Mediator {
    Set<Colleague> colleagues;
    public void register(Colleague colleague){
        if (colleagues == null){
            colleagues = new HashSet<>(16);
        }
        this.colleagues.add(colleague);
    }
    public Set<Colleague> getColleagues(){
        return this.colleagues;
    }
    public abstract void contact(Colleague colleague,String message);
}
