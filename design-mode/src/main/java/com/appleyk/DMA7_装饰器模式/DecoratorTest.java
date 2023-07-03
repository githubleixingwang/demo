package com.appleyk.DMA7_装饰器模式;

import com.appleyk.DMA7_装饰器模式.DM7.*;

/**
 * <p>装饰者模式测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午4:05:50
 */
public class DecoratorTest {


    public static void main(String[] args) {
        System.out.println(AAAA.str);
     /*   AAAA.me();
          AAAA.me();*/
        /**
         * 扩展在Windows系统中的文件创建和删除功能
         */
        IFolder iFolder;
        iFolder = new FolderA();
        iFolder = new FolderDecorator1(iFolder);
        iFolder = new FolderDecorator2(iFolder);
        System.out.println(iFolder.mkDir());

        /**
         * 扩展在Linux系统中的文件创建和删除功能
         */
        iFolder = new FolderB();
        iFolder = new FolderDecorator1(iFolder);
        iFolder = new FolderDecorator2(iFolder);
        System.out.println(iFolder.mkDir());
        System.out.println(BBBB.map);        /**
         * 好处：动态扩展类的功能，原始类无需做修改，只需增加一个装饰类即可实现
         * 坏处：相似类的对象创建的过多，比如，扩展的功能很少，你是会选择增加一个装饰类呢，还是在原有类中直接做修改呢？
         *
         * 如果考虑到设计模式的开闭原则：即对扩展开放，对修改关闭，那么牺牲一点内存空间达到类功能的扩展也是很有必要的
         */
    }
}
