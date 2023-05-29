package com.appleyk.DMB18_命令模式.DM18.开关灯;

/**
 * <p>命令接口</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  15:42 2021/10/29
 */
public interface ICommand {
    /**执行，屏蔽执行的细节，将请求者和调用者解耦*/
    void execute();
    /**撤销，常规支持*/
    void undo();
}
