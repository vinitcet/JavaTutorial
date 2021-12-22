package com.vinit.example.myntra;

public class DistanceFromRoot {
    // A Binary Tree Node
    static class Node {
        int data;
        Node left, right;
    }

    // Tree Node
    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    /*              5
                /       \
               10       15
               / \        /  \
               20  25   30   35
                     \
                     45
               */
    public static void main(String[] args) {
        Node root = newNode(5);
        root.left = newNode(10);
        root.right = newNode(15);
        root.left.left = newNode(20);
        root.left.right = newNode(25);
        root.left.right.right = newNode(45);
        root.right.left = newNode(30);
        root.right.right = newNode(35);

        System.out.println(findDistance(root, 45));
    }

    static int findDistance(Node root, int x) {
        // Base case
        if (root == null)
            return -1;

        // Initialize distance
        int dist = -1;

        // Check if x is present at root or in left
        // subtree or right subtree.
        if ((root.data == x) ||
                (dist = findDistance(root.left, x)) >= 0 ||
                (dist = findDistance(root.right, x)) >= 0)
            return dist + 1;

        return dist;
    }

}
