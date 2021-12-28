package com.vinit.example.google;
/*A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
        has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
        The path sum of a path is the sum of the node's values in the path.
        Given the root of a binary tree, return the maximum path sum of any non-empty path.*/

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {

    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int curr_max = Math.max(Math.max(left, right) + root.val, root.val);
        max = Math.max(max, Math.max(curr_max, root.val + left + right));
        return curr_max;
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

