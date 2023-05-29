package com.appleyk.DMC22_访问者模式.软件升级;

/**
 * <p>
 *     抽象软件（系统）模块类
 *        模块包含多个子模块，每个子模块都拥有自己独立的功能，在软件（系统）一开始部署给客户后，
 *     其功能是确定的，但是经过一段时间的使用后，如果用户想要升级功能的话，我们的系统模块要留有口子
 *     可以在原有的代码结构上快速扩展"新功能",注意不改变原有模块代码结构？ 怎么做到呢？这时候我们就
 *     急需有一个类可以访问到我们系统需要暴露给用户端进行升级的模块，通过这个类来操作模块对象，对模块
 *     对象进行功能扩展，然后客户端部署的程序留一个更新的方法，将这个类传过去以扩展相应的模块功能即可，
 *     即一旦客户端更新后，再次运行程序会发现，功能已经升上去了！这个类就是我们的具体的Visitor！
 * </p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:12 2022/10/17
 */
public abstract class AbstractModule {
    String function;
    public void desc(){
        System.out.println(function);
    }
    public abstract void accept(Visitor visitor);
}
