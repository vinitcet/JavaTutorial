package com.vinit.example.paypal;
/*
Find the distance between two keys in a binary tree, no parent pointers are given.
The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.
*/
public class NodeDistanceTree {
    static class Node {
        Node left, right;
        int key;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public static Node LCA(Node root, int a, int b) {
        if (root == null)
            return null;

        // If either a or b matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.key == a || root.key == b)
            return root;

        // Look for keys in left and right subtrees
        Node left_lca = LCA(root.left, a, b);
        Node right_lca = LCA(root.right, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static int findLevel(Node root, int a, int level) {
        if (root == null) {
            return -1;
        }
        if (root.key == a) {
            return level;
        }
        int left = findLevel(root.left, a, level + 1);
        if (left == -1) {
            return findLevel(root.right, a, level + 1);
        }
        return left;
    }

    public static void calculateMinimumDistance(Node n, int a, int b) {
        Node LCA = LCA(n, a, b);
        int a1 = findLevel(LCA, a, 0);
        int a2 = findLevel(LCA, b, 0);
        System.out.println("Minimum Distance is: "+(a1+a2));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        calculateMinimumDistance(root, 4, 8);
    }

}
