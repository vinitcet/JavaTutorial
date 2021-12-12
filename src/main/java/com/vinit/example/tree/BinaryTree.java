package com.vinit.example.tree;

import java.util.*;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        this.key = item;
        left = right = null;
    }

}

class Distance {
    int minDistance = Integer.MAX_VALUE;
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

    void leftView() {
        leftViewUtil(root, 1);
    }

    static int max_level = 0;

    public void leftViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(" " + node.key);
            max_level = level;
        }
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }

    int height(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }

    void printZigZagTree() {
        printZigZagTree(root);
    }

    void printZigZagTree(Node node) {
        if (node == null) {
            return;
        }
        boolean right = true;
        int heightOfTree = height(node);
        for (int i = 1; i <= heightOfTree; i++) {
            if (i % 2 == 0) {
                right = true;
            } else {
                right = false;
            }
            printLevel(node, i, right);
        }
    }

    public void printLevel(Node node, int level, boolean right) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.key + " -> ");
            return;
        }
        if (!right) {
            printLevel(node.left, level - 1, right);
            printLevel(node.right, level - 1, right);
        } else {
            printLevel(node.right, level - 1, right);
            printLevel(node.left, level - 1, right);
        }
    }

    // This function finds closest leaf to root.  This distance
    // is stored at *minDist.
    public void findLeafDown(Node root, int level, Distance minDistance) {
        if (root == null) {
            return;
        }
        // If this is a leaf node, then check if it is closer
        // than the closest so far
        if (root.left == null && root.right == null) {
            if (level < minDistance.minDistance) {
                minDistance.minDistance = level;
                return;
            }
        }
        // Recur for left and right subtrees
        findLeafDown(root.left, level + 1, minDistance);
        findLeafDown(root.right, level + 1, minDistance);
    }

    public int findThroughRoot(Node root, Node node, Distance minDistance) {
        if (root == null) {
            return -1;
        }
        if (root == node) {
            return 0;
        }
        // Search x in left subtree of root
        int l = findThroughRoot(root.left, node, minDistance);
        // If left subtree has x
        if (l == -1) {
            // Find closest leaf in right subtree
            findLeafDown(root.right, l + 2, minDistance);
            return l + 1;
        }
        // Search x in right subtree of root
        int r = findThroughRoot(node.right, node, minDistance);
        // If right subtree has x
        if (r == -1) {
            // Find closest leaf in left subtree
            findLeafDown(root.left, r + 2, minDistance);
            return r + 1;
        }
        return -1;
    }

    int minimumDistance(Node root, Node node) {
        Distance d = new Distance();
        findLeafDown(node, 0, d);
        findThroughRoot(root, node, d);
        return d.minDistance;

    }

    void mirror() {
        mirror(root);
    }

    Node mirror(Node node) {
        if (node == null) {
            return node;
        }
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        //swap
        node.left = right;
        node.right = left;
        return node;
    }

    // returns true if trees
    //  with roots as root1 and root2are mirror
    boolean isMirror(Node node1, Node node2) {
        // if both trees are empty,
        //  then they are mirror image
        if (node1 == null && node2 == null)
            return true;

        // For two trees to be mirror images, the following
        // three conditions must be true 1 - Their root
        // node's key must be same 2 - left subtree of left
        // tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
        if (node1 != null && node2 != null
                && node1.key == node2.key)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));
        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }

    Node prev;

    boolean isBST() {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(Node node) {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null) {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.key <= prev.key)
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    void longestBranch() {
        System.out.println();
        longestPath(root).forEach(System.out::println);
    }

    public ArrayList<Integer> longestPath(Node node) {
        if (node == null) {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }
        ArrayList<Integer> right = longestPath(node.right);
        ArrayList<Integer> left = longestPath(node.left);
        if (left.size() > right.size()) {
            left.add(node.key);
        } else {
            right.add(node.key);
        }
        return (left.size() >
                right.size() ? left : right);
    }

    // Utility function to store vertical order in map 'm'
    // 'hd' is horizontal distance of current node from root.
    // 'hd' is initially passed as 0
    void getVerticalOrder(Node root, int hd,
                                 TreeMap<Integer,Vector<Integer>> m)
    {
        // Base case
        if(root == null)
            return;

        //get the vector list at 'hd'
        Vector<Integer> get =  m.get(hd);

        // Store current node in map 'm'
        if(get == null)
        {
            get = new Vector<>();
            get.add(root.key);
        }
        else
            get.add(root.key);

        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, m);
    }

    // The main function to print vertical order of a binary tree
    // with the given root
    void printVerticalOrder()
    {
        // Create a map and store vertical order in map using
        // function getVerticalOrder()
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,m);

        // Traverse the map and print nodes at every horizontal
        // distance (hd)
        for (Map.Entry<Integer, Vector<Integer>> entry : m.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }

    /* Function to find LCA of n1 and n2. The function assumes that both
      n1 and n2 are present in BST */
    Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.key < n1 && node.key < n2)
            return lca(node.right, n1, n2);

        return node;
    }
    /*              3
                2       8
            1          5
        */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(1);
        tree.root.left.left.left = new Node(0);
        tree.root.right.left = new Node(5);

        tree.inOrderTraversal();
        System.out.println();
        /*tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
        System.out.println();
        tree.printLevelOrder();
        System.out.println();
        tree.printLeft();
        System.out.println("Left view:");
        tree.leftView();
        System.out.println();
        tree.printZigZagTree();*/
        //tree.mirror();
        //tree.inOrderTraversal();
        //tree.longestBranch();
        tree.printVerticalOrder();
    }
}
