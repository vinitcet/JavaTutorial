package com.vinit.example.myntra;

import java.util.ArrayList;
import java.util.List;

/*Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly
        n nodes of unique values from 1 to n. Return the answer in any order.*/
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(19));
        List<TreeNode> ls = generateTrees(4);

    }

    public static int numTrees(int n) {
        int i, j;
        int[] count = new int[n + 2];
        count[0] = 1;
        count[1] = 1;
        for (i = 2; i <= n; i++) {
            for (j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftTrees = helper(start, rootVal - 1);
            List<TreeNode> rightTrees = helper(rootVal + 1, end);
            for (int i = 0; i < leftTrees.size(); i++) {
                TreeNode leftTree = leftTrees.get(i);
                for (int j = 0; j < rightTrees.size(); j++) {
                    TreeNode rightTree = rightTrees.get(j);
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
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