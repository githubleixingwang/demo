package com.appleyk.DMB18_命令模式.DM18.开关灯;

/**
 * <p>卧室关灯命令</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  16:00 2021/10/29
 */
public class LightOffCommand implements ICommand{
    private Bedroom bedroom;

    public void setBedroom(Bedroom bedroom) {
        this.bedroom = bedroom;
    }

    @Override
    public void execute() {
        bedroom.off();
    }
    @Override
    public void undo() {
        bedroom.on();
    }
}
