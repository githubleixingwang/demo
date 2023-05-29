package com.appleyk.DMC22_访问者模式.软件升级;

/**
 * <p>具体的访问者实现类，主要实现对数据和服务模块的功能扩展</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:28 2022/10/17
 */
public class UpdateModuleVisitor implements Visitor {
    @Override
    public void visitService(ServiceModule serviceModule) {
        serviceModule.function += "；本次服务模块新增了对OGC服务的全面支持和接入!";
    }

    @Override
    public void visitData(DataModule dataModule) {
        dataModule.addDataType("shp");
        dataModule.addDataType("img");
    }
}
