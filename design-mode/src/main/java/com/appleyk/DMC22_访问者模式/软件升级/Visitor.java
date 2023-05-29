package com.appleyk.DMC22_访问者模式.软件升级;

/**
 * <p>访问者接口，暴露两个方法，留给具体的子类来等于暴露方法中的对象进行功能扩展</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:14 2022/10/17
 */
public interface Visitor {
    /**可以访问到服务模块对象，即服务模块中的功能对访问者来说是透明的*/
    void visitService(ServiceModule serviceModule);
    /**可以访问到数据模块对象，即数据模块中的功能对访问者来说是透明的*/
    void visitData(DataModule dataModule);
}
