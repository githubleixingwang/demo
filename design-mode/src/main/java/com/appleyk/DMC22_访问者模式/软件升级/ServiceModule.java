package com.appleyk.DMC22_访问者模式.软件升级;

/**
 * <p>服务模块</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:20 2022/10/17
 */
public class ServiceModule extends AbstractModule{

    public ServiceModule(String function){
        this.function = function;
    }

    @Override
    public void accept(Visitor visitor) {
        /**将自己交给访问者实例，暴露自己，成全扩展*/
        visitor.visitService(this);
    }
}
