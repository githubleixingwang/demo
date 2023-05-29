package com.appleyk.DMC22_访问者模式.软件升级;

/**
 * <p>客户端，持有部署软件的模块功能及一个可以随时更新模块功能的API</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:32 2022/10/17
 */
public class Client {

    private DataModule dataModule;
    private ServiceModule serviceModule;

    public Client() {
        this.dataModule = new DataModule("数据管理模块主要基于不同类型数据进行入库和出库操作！");
        this.serviceModule = new ServiceModule("服务模块基于原始数据进行切片后的服务发布！");
    }

    public void run(){
        dataModule.desc();;
        System.out.println("===================");
        serviceModule.desc();
    }

    public void updateModule(Visitor visitor){
        System.out.println("<<<<<<<<<<<<开始更新程序>>>>>>>>>>>>>>>");
        /**接收访问者访问自己，然后借助visitor来扩展自己原有的功能*/
        serviceModule.accept(visitor);
        System.out.println("===========更新服务模块结束");
        dataModule.accept(visitor);
        System.out.println("===========更新数据模块结束");
    }


}
