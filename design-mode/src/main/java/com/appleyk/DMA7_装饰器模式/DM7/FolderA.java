package com.appleyk.DMA7_装饰器模式.DM7;

/**
 * <p>文件夹A</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午4:15:39
 */
public class FolderA extends IFolder {

    @Override
    public String mkDir() {
        return "Windows系统创建文件夹";
    }

    @Override
    public void rmdir() {
        System.out.println("在Windows系统中删除文件夹A");
    }

}
