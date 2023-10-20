package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:45
 */
public class Res implements Serializable {

    private String aaa;
    private String bbb;
    private ShellCommand shellCommand;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }
    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }
    public ShellCommand getShellCommand() {
        return shellCommand;
    }

    public void setShellCommand(ShellCommand shellCommand) {
        this.shellCommand = shellCommand;
    }


    @Override
    public String toString() {
        return "Res{" +
                "aaa='" + aaa + '\'' +
                ", bbb='" + bbb + '\'' +
                ", shellCommand=" + shellCommand +
                '}';
    }
}
