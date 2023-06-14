package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:42
 */
public class DigesterObj implements Serializable {
 private Parameters parameters;
 private  Shared shared;

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Shared getShared() {
        return shared;
    }

    public void setShared(Shared shared) {
        this.shared = shared;
    }

    @Override
    public String toString() {
        return "DigesterObj{" +
                "parameters=" + parameters +
                ", shared=" + shared +
                '}';
    }
}
