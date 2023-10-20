package com.demo.test.xmldigester.bean;

import java.io.Serializable;

/**
 * @author: lxw
 * @date: 2023-06-14  10:42
 */
public class DigesterObj implements Serializable {
    private Parameters parameters;
    private Shared shared;
    private Layer rootLayer;//根layer

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

    public Layer getLayer() {
        return rootLayer;
    }

    public void setLayer(Layer layer) {
        this.rootLayer = layer;
    }
    public void addLayerList(Layer layer){
        this.rootLayer = layer;
    }
    @Override
    public String toString() {
        return "DigesterObj{" +
                "parameters=" + parameters +
                ", shared=" + shared +
                ", layer=" + rootLayer +
                '}';
    }
}
