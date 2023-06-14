package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:45
 */
public class Res implements Serializable {
    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    private String aaa;
    private ShellCommand shellCommand;

    public ShellCommand getShellCommand() {
        return shellCommand;
    }

    public void setShellCommand(ShellCommand shellCommand) {
        this.shellCommand = shellCommand;
    }


    @Override
    public String toString() {
        return "Res{" +
                "aaa=" + aaa +
                ", shellCommand=" + shellCommand +
                '}';
    }
}
