package com.vinit.example.practice;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {


    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);
        TreeNode opNode = new TreeNode(ls.get(0));
        for (int i =1;i<ls.size();i++){
            //opNode.right
        }


        return opNode;
    }

    public void inorder(TreeNode node, List ls) {
        while (node != null) {
            inorder(node.left, ls);
            ls.add(node.val);
            inorder(node.right, ls);

        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}