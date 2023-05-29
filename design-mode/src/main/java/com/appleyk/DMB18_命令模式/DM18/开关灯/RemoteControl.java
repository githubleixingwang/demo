package com.appleyk.DMB18_命令模式.DM18.开关灯;

/**
 * <p>遥控器，相当于CMD模式中的【 invoker 】</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  15:46 2021/10/29
 */
public class RemoteControl {

    /**遥控器开按钮，不同的槽位，实现不同对象的开闭操作，比如开空调，开电视机，开卧室的灯等*/
    private ICommand[] OnCommands;
    /**遥控器关按钮，不同的槽位，实现不同对象的关闭操作，同上.....*/
    private ICommand[] OffCommands;
    /**撤销操作需要记录最后一个命令是什么*/
    private ICommand undoCommand;
    public RemoteControl() {
        OnCommands = new ICommand[1];
        OffCommands = new ICommand[1];
        OnCommands[0] = new NoCommand();
        OffCommands[0] = new NoCommand();
    }

    public void setCommand(int slot,ICommand onCommand,ICommand offCommand){
        OnCommands[slot] = onCommand;
        OffCommands[slot] = offCommand;
    }

    /**按下对应槽位上的开按钮*/
    public void onButtonPushed(int slot){
        OnCommands[slot].execute();
        undoCommand = OnCommands[slot];
    }
    /**按下对应槽位上的关按钮*/
    public void offButtonPushed(int slot){
        OffCommands[slot].execute();
        undoCommand = OffCommands[slot];
    }

    public void undoButtonPushed(){
        System.out.println("===>你按下了撤销按钮");
        undoCommand.undo();
    }

}
