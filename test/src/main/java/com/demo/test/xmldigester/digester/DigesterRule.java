package com.demo.test.xmldigester.digester;

import com.demo.test.xmldigester.bean.*;
import org.apache.commons.digester.Digester;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: lxw
 * @date: 2023-06-14  10:54
 */
@Component
public class DigesterRule {

    public void initRule() throws IOException, SAXException {
        Digester digester = new Digester();

        digester.addObjectCreate("DigesterObj", DigesterObj.class);//当匹配到xml中DigesterObj节点时会创建DigesterObj对象,并将创建的对象push到stack栈顶

        digester.addObjectCreate("DigesterObj/Parameters", Parameters.class);
        digester.addBeanPropertySetter("DigesterObj/Parameters/version", "version");//当匹配到xml中DigesterObj/Parameters/version是,将xml中DigesterObj/Parameters/version的值赋值给DigesterObj对象的version属性
        digester.addBeanPropertySetter("DigesterObj/Parameters/sortPriority", "sortPriority");
        digester.addCallMethod("DigesterObj/Parameters/Param", "putParam", 2);//匹配到节点时会调用stack栈顶元素对象的methodName方法（反射），（有参，指定参数个数与CallParamRule规则配合使用，设置参数值）
        digester.addCallParam("DigesterObj/Parameters/Param", 0, "key");//当匹配到模式时，配置参数下标及对应的节点名称，设置putParam方法的参数
        digester.addCallParam("DigesterObj/Parameters/Param", 1, "value");
        digester.addSetNext("DigesterObj/Parameters", "setParameters");//当匹配到模式，调用栈顶元素的上一个元素的methodName方法并以栈顶元素作为参数（反射）,弹出栈顶的对象

        digester.addObjectCreate("DigesterObj/Shared", Shared.class);
        digester.addObjectCreate("DigesterObj/Shared/Res", Res.class);
        digester.addSetProperties("DigesterObj/Shared/Res");//匹配到Res节点时，会将Res节点中的属性设置到Res对象中，示例中设置的是aaa
        digester.addObjectCreate("DigesterObj/Shared/Res/ShellCommand", ShellCommand.class);
        digester.addBeanPropertySetter("DigesterObj/Shared/Res/ShellCommand/Command", "command");
        digester.addSetNext("DigesterObj/Shared/Res/ShellCommand", "setShellCommand");
        digester.addSetNext("DigesterObj/Shared/Res", "setRes");
        digester.addSetNext("DigesterObj/Shared", "setShared");

        InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream("xml/test.xml");
        DigesterObj parse = (DigesterObj) digester.parse(resource);
        System.out.println(parse.toString());

    }

}
