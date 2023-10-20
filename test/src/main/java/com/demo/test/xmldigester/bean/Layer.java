package com.demo.test.xmldigester.bean;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: lxw
 * @date: 2023-10-20  10:18
 */
public class Layer {

    private String name;
    private Layer parentLayer;
    private List<Layer> layerList = Lists.newArrayList();
    private List<Node> nodeList = Lists.newArrayList();

    public void addLayerList(Layer layer) {
        layer.setParentLayer(this);
        layerList.add(layer);
       // nodeList.addAll(layer.getNodeList()); 根据业务自定义封装数据：此处会设置父layer的nodeList包含子layer的所有nodeList
    }

    public void addNodeList(Node node) {
        nodeList.add(node);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Layer getParentLayer() {
        return parentLayer;
    }

    public void setParentLayer(Layer parentLayer) {
        this.parentLayer = parentLayer;
    }

    public List<Layer> getLayerList() {
        return layerList;
    }

    public void setLayerList(List<Layer> layerList) {
        this.layerList = layerList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }


   // @Override
 /*   public String toString() {
        return "Layer{" +
                "name='" + name + '\'' +
                ", parentLayer=" + parentLayer +
                ", layerList=" + layerList +
                ", nodeList=" + nodeList +
                '}';
    }*/
}
