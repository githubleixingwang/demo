package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:47
 */
public class ShellCommand implements Serializable {

    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "ShellCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}
