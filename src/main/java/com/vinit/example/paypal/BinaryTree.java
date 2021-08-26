package com.vinit.example.paypal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    Node addRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }
        if (data < root.data) {
            root.left = addRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = addRecursive(root.right, data);
        } else {
            return root;
        }
        return root;
    }

    //LNR
    public void traverseInorder(Node n) {
        if (n != null) {
            traverseInorder(n.left);
            System.out.print(n.data + " ");
            traverseInorder(n.right);
        }
    }

    //NLR
    public void traversePreOrder(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            traversePreOrder(n.left);
            traversePreOrder(n.right);
        }
    }

    //LRN
    public void traversePostOrder(Node n) {
        if (n != null) {
            traversePostOrder(n.left);
            traversePostOrder(n.right);
            System.out.print(n.data + " ");
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.remove();
            System.out.print(" " + n.data);
            if (n.left != null) {
                nodeQueue.add(n.left);
            }
            if (n.right != null) {
                nodeQueue.add(n.right);
            }
        }
    }


    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean findElement(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.data) {
            return true;
        }
        return value < root.data ?
                findElement(root.left, value) : findElement(root.right, value);
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

    void LCA(int a, int b) {
        ArrayList<Integer> firstList = getAllElements(root, a, new ArrayList<Integer>());
        ArrayList<Integer> secondList = getAllElements(root, b, new ArrayList<Integer>());

        int smallList = firstList.size() > secondList.size() ? secondList.size() : firstList.size();

        for (int i = 0; i < smallList; i++) {
            if (firstList.get(i) != secondList.get(i)) {
                System.out.println("The LCA of " + a + " and " + b + " is : " + firstList.get(i - 1));
                break;
            }
        }
        if (firstList.get(smallList - 1) == secondList.get(smallList-1) ) {
            System.out.println("The LCA of " + a + " and " + b + " is : " + firstList.get(smallList - 1));
        }
    }

    ArrayList<Integer> getAllElements(Node head, int val, ArrayList al) {
        if (head == null) {
            return al;
        }
        if (head.data == val) {
            al.add(head.data);
            return al;
        } else if (val > head.data) {
            al.add(head.data);
            getAllElements(head.right, val, al);

        } else {
            al.add(head.data);
            getAllElements(head.left, val, al);

        }
        return al;
    }

    //                 6
//                   /   \
//                  4      8
//                 / \   /  \
//                3   5  7   9
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.println(bt);
        System.out.println(bt.findElement(bt.root, 7));
        bt.traverseInorder(bt.root);
        System.out.println();
        bt.traversePreOrder(bt.root);
        System.out.println();
        bt.traversePostOrder(bt.root);
        System.out.println();
        bt.traverseLevelOrder();
        System.out.println();
        bt.LCA(3, 4);
        bt.LCA(7, 5);
        bt.LCA(7, 9);
    }
}