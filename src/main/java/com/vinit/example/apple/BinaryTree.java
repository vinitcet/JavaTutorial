package com.vinit.example.apple;

// A JAVA program to demonstrate serialization and
// deserialiation of Binary Tree
import java.util.*;

/* A binary tree Node has key, pointer to left and right
 * children */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTree {
    TreeNode root;

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root)
    {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        List<String> l = new ArrayList<>();
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            // If current node is NULL, store marker
            if (t == null) {
                l.add("#");
            }
            else {
                // Else, store current node and recur for
                // its children
                l.add("" + t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        System.out.println("Before adding comma : "+l);
        return String.join(",", l);
    }

    static int t;

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data)
    {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public static TreeNode helper(String[] arr)
    {
        if (arr[t].equals("#"))
            return null;
        // create node with this item and recur for children
        TreeNode root
                = new TreeNode(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }

    // A simple inorder traversal used for testing the
    // constructed tree
    static void inorder(TreeNode root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    /* Driver program to test above functions*/
    public static void main(String args[])
    {
//                 20
//                /  \
//                8	   22
//               / \
//              4  12
//                /  \
//               10  14
        // Let us construct a tree shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        inorder(tree.root);
        System.out.println();
        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        TreeNode t = deserialize(serialized);

        System.out.println(
                "Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);
    }
}