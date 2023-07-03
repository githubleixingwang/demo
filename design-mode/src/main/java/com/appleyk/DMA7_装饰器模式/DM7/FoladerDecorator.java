package com.appleyk.DMA7_装饰器模式.DM7;

/**
 * @author: lxw
 * @date: 2023-06-29  10:41
 */
public abstract class FoladerDecorator extends IFolder{
    private IFolder iFolder;


    public FoladerDecorator(IFolder iFolder) {
        this.iFolder = iFolder;
    }

    @Override
    public String mkDir() {
        return iFolder.mkDir();
    }

    @Override
    public void rmdir() {

    }
}
