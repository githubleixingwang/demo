package com.appleyk.DMC22_访问者模式.软件升级;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>数据模块</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:23 2022/10/17
 */
public class DataModule extends AbstractModule {

    public List<String> dataTypes ;

    public DataModule(String function){
        this.function = function;
        dataTypes = new ArrayList<>();
        dataTypes.add("dem");
        dataTypes.add("tif");
    }

    public void addDataType(String type){
        this.dataTypes.add(type);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("支持的类型有："+dataTypes.toString());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitData(this);
    }
}
