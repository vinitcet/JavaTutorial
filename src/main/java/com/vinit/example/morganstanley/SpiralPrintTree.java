package com.vinit.example.morganstanley;

import java.util.LinkedList;
import java.util.Queue;

public class SpiralPrintTree {
    Node root;

    void add(int val) {
        root = addRecursive(root, val);
    }

    Node addRecursive(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        }
        if (root.data > val) {
            root.right = addRecursive(root.right, val);
        } else if (root.data < val) {
            root.left = addRecursive(root.left, val);
        } else {
            return root;
        }
        return root;
    }

    void displayInorder(Node root) {
        if (root != null) {
            displayInorder(root.left);
            System.out.print(root.data + " ");
            displayInorder(root.right);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    void printSpiral() {
        int h = height(root);
        int i;

        boolean ltr = false;
        for (i = 1; i <= h; i++) {
            printTree(root, i, ltr);
            ltr = !ltr;
        }
    }

    public void printTree(Node node, int level, boolean ltr) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) {
            if (ltr != false) {
                printTree(node.left, level - 1, ltr);
                printTree(node.right, level - 1, ltr);
            } else {
                printTree(node.right, level - 1, ltr);
                printTree(node.left, level - 1, ltr);
            }
        }
    }


    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight) {
                return lheight + 1;
            } else {
                return rheight + 1;
            }
        }

    }

    void printLevel(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.remove();
            System.out.print(n.data + " ");
            if (n.left != null) {
                nodeQueue.add(n.left);
            }
            if (n.right != null) {
                nodeQueue.add(n.right);
            }
        }
    }

    void printElement(int row, int column) {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);


        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.remove();
            System.out.print(n.data + " ");

            if (n.left != null) {
                nodeQueue.add(n.left);
            }
            if (n.right != null) {
                nodeQueue.add(n.right);
            }

        }
    }
//                     6
//                   /   \
//                  4      8
//                 / \   /  \
//                3   5  7   9

    public static void main(String[] args) {
        SpiralPrintTree bt = new SpiralPrintTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.println(bt);
        bt.displayInorder(bt.root);
        System.out.println();
        System.out.println("Height of tree: " + bt.height(bt.root));
        bt.printLevel(bt.root);
        System.out.println();
        bt.printSpiral();
        System.out.println();
       // bt.printElement(row, column);
    }
}
