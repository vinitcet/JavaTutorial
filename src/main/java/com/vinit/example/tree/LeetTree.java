package com.vinit.example.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetTree {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(9);
        tr.left = new TreeNode(8);
        tr.right = new TreeNode(1);
        tr.left.left = new TreeNode(7);
        tr.left.right = new TreeNode(3);
        tr.left.right.left = new TreeNode(3);
        tr.left.left.left = new TreeNode(6);
        tr.left.left.left.right = new TreeNode(7);
        print(tr);
        findDuplicates(tr);
        //System.out.println(findSecondMinimumValue(tr));
        //findSecondMinimumValueMine(tr);
        //rightSideView(tr).forEach(System.out::println);
        //lowestCommonAncestor(tr, tr.left.right, tr.right);
    }

    public static void print(TreeNode node) {
        if (node == null) {
            return;
        } else {
            print(node.left);
            System.out.print(node.val + " -> ");
            print(node.right);
        }

    }

    public static void findDuplicates(TreeNode node) {
        List<Integer> ls = new ArrayList();
        findDuplicates(node, ls);
        Set<Integer> unique = new HashSet<>();
        System.out.println("Duplicates in tree");
        for (int i : ls) {
            if (!unique.contains(i)) {
                unique.add(i);
            } else {
                System.out.print(i + " ");
            }
        }
    }

    public static void findDuplicates(TreeNode node, List ls) {
        if (node == null) {
            return;
        } else {
            findDuplicates(node.left, ls);
            ls.add(node.val);
            findDuplicates(node.right, ls);
        }
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

    static int maxlevel = 0;

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        return rightSideView(root, 1, al);

    }

    public static List<Integer> rightSideView(TreeNode root, int level, List<Integer> al) {
        if (root == null) {
            return null;
        }
        if (maxlevel < level) {
            System.out.println(root.val + " ");
            al.add(root.val);
            maxlevel = level;
        }
        rightSideView(root.right, level + 1, al);
        rightSideView(root.left, level + 1, al);
        return al;
    }

    /*    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
        lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”*/
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {

            return root;
        }
        TreeNode left = (lowestCommonAncestor(root.left, p, q));
        TreeNode right = (lowestCommonAncestor(root.right, p, q));
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        return root;
    }

    static TreeNode prev = null;


    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            return isValidBST(root.right);
        }
        return true;
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