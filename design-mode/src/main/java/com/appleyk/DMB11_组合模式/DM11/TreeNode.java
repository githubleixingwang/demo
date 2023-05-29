package com.appleyk.DMB11_组合模式.DM11;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>树节点</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:23 2018-11-21
 */
public class TreeNode {

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点的父节点
     */
    private TreeNode parent;

    /**
     * 节点的子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public void addChildren(TreeNode node) {
        // 别忘设置节点的父
        node.setParent(this);
        this.children.add(node);
    }

    public TreeNode addChildren(String node) {
        TreeNode cNode = new TreeNode(node);
        // 别忘设置节点的父
        cNode.setParent(this);
        this.children.add(cNode);
        return cNode;
    }

    public void removeChildren(TreeNode node) {
        this.children.remove(node);
    }

    /**
     * 是否是叶子
     */
    public boolean isLeaf() {
        return !(this.children.size() > 0) && (this.parent != null);
    }

    /**
     * 是否有父节点 == 如果没有，就是根节点
     */
    public boolean hasParent() {
        return !(this.parent == null);
    }

    /**
     * 根节点没有父节点
     */
    public boolean isRoot() {
        return this.parent == null;
    }
}
