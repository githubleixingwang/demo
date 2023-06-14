package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:44
 */
public class Shared implements Serializable {

    private Res res;

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Shared{" +
                "res=" + res +
                '}';
    }
}
