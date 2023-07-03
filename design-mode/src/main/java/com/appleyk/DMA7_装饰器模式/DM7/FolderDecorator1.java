package com.appleyk.DMA7_装饰器模式.DM7;

/**
 * <p>
 * 文件夹装饰类，扩展文件夹创建和删除的类 == 在创建和删除前后进行相应的操作
 * </p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 2018年11月10日 - 下午4:18:36
 */
public class FolderDecorator1 extends FoladerDecorator {

    public FolderDecorator1(IFolder folder) {
        super(folder);
    }


    @Override
    public String mkDir() {
        return super.mkDir()+"文件夹名称为a";
    }

    @Override
    public void rmdir() {
        System.out.println("-- 刪除 --");
    }


}
