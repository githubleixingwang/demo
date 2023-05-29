package com.appleyk.DMC22_访问者模式.软件升级.测试;

import com.appleyk.DMC22_访问者模式.软件升级.Client;
import com.appleyk.DMC22_访问者模式.软件升级.UpdateModuleVisitor;

/**
 * <p>越努力，越幸运</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午11:31 2022/10/17
 */
public class VisitorTest {
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
        client.updateModule(new UpdateModuleVisitor());
        client.run();
    }
}
