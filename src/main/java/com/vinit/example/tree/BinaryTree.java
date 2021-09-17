package com.vinit.example.tree;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        this.key = item;
        left = right = null;
    }

}

public class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.print(node.key + " -> ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.key + " -> ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.key + " -> ");
        }
    }

    int treeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lheight = treeHeight(node.left);
        int rheight = treeHeight(node.right);

        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    void inOrderTraversal() {
        inOrderTraversal(root);
    }

    void preOrderTraversal() {
        preOrderTraversal(root);
    }

    void postOrderTraversal() {
        postOrderTraversal(root);
    }

    void printLevelOrder() {
        int h = treeHeight(root);
        System.out.println("Height of the tree is :: " + h);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    void printCurrentLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.key + " -> ");
        }
        printCurrentLevel(node.left, level - 1);
        printCurrentLevel(node.right, level - 1);
    }

    void insert(int key) {
        insertvalue(root, key);
    }

    Node insertvalue(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (root.key > key) {
            insertvalue(root.left, key);
        } else {
            insertvalue(root.right, key);
        }
        return root;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    void printLeft() {
        System.out.println("Left most element: " + printLeftMost(root));
    }

    int printLeftMost(Node root) {
        if (root.left == null) {
            return root.key;
        } else {
            printLeftMost(root.left);
        }
        return 0;
    }

    /*              1
                2       3
            4       5
        */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.inOrderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
        System.out.println();
        tree.printLevelOrder();
        tree.printLeft();
    }

}
