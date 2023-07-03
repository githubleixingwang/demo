package com.appleyk.DMA7_装饰器模式.DM7;

/**
 * @author: lxw
 * @date: 2023-06-29  10:56
 */
public class FolderDecorator2 extends FoladerDecorator{
    public FolderDecorator2(IFolder iFolder) {
        super(iFolder);
    }

    @Override
    public String mkDir() {
        return super.mkDir()+"没有后缀";
    }

    @Override
    public void rmdir() {

    }
}
