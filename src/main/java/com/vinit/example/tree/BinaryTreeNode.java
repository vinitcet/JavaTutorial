package com.vinit.example.tree;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode leftNode, rightNode;

    public BinaryTreeNode(int data) {
        this.data = data;
        leftNode = null;
        rightNode = null;

    }

    public void preOrder (BinaryTreeNode root){
        if (root!=null){
            System.out.println(root.data);
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
