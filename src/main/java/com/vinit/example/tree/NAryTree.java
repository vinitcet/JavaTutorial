package com.vinit.example.tree;

import java.util.ArrayList;
import java.util.List;

public class NAryTree {

    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);

        for (int i = 0; i < root.children.size(); i++) {
            List<Integer> labels = preorder(root.children.get(i));
            for (int j = 0; j < labels.size(); j++) {
                result.add(labels.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> ls1 = new ArrayList();
        Node root1 = new Node(3);
        Node root2 = new Node(2);
        Node root3 = new Node(4);
        ls1.add(root1);
        ls1.add(root2);
        ls1.add(root3);
        root.children = new ArrayList<>(ls1);
        List<Node> ls2 = new ArrayList();
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        ls2.add(root5);
        ls2.add(root6);
        ls1.get(0).children = ls2;
        List<Integer> result = preorder(root);
        for (Integer s : result) {
            System.out.print(s + "  ");
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}