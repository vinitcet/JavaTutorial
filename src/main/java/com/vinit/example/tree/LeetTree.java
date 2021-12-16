package com.vinit.example.tree;

public class LeetTree {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(9);
        tr.left = new TreeNode(8);
        tr.left.left = new TreeNode(7);
        tr.left.left.left = new TreeNode(6);

        //System.out.println(findSecondMinimumValue(tr));
        findSecondMinimumValueMine(tr);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    static int count = 0;

    public static void findSecondMinimumValueMine(TreeNode root) {
        if (root != null) {
            findSecondMinimumValueMine(root.left);
            System.out.print(root.val + " ");
            findSecondMinimumValueMine(root.right);
        }

    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int left = root.left.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        int right = root.right.val;
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
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