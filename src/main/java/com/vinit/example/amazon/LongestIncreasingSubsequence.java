package com.vinit.example.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    private static Node head;

    public static void main(String[] args) {
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        //50->3->10->7->40->80
        // 3->10->2->1->20
        int[] i = {3, 10, 2, 1, 20};
        //int[] i = {60, 3, 10, 7, 40, 80};
        for (int a : i) {
            insertInEnd(a);
        }

        printLongestSubSequence(ls.head);
        printLongestSubSequence2(ls.head);
        printLongestSubSequence3(ls.head);
    }

    public static void insertInEnd(int data) {
        Node node = head;
        if (head == null) {
            head = new Node(data);
            return;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
    }

    public static void printLongestSubSequence2(Node head) {
        Node node = head;
        TreeSet<Integer> mySet = new TreeSet<>();
        while (node != null) {
            Integer ceil = mySet.ceiling(node.data);
            if (ceil != null) {
                mySet.remove(ceil);
            }
            mySet.add(node.data);
            node = node.next;
        }

        System.out.println(mySet + " " + mySet.size());
    }

    public static void printLongestSubSequence3(Node head) {
        Node node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            int index = Collections.binarySearch(list, node.data);
            // if element is present no need to add again
            // otherwise insert it at the given insertion points which is (-(index) - 1)
            if (index < 0) {
                index = (-index) - 1;
                if (index >= list.size()) {
                    list.add(node.data);
                } else {
                    list.set(index, node.data);
                }
            }
            node = node.next;
        }
        System.out.println(list + " " + list.size());

    }

    public static void printLongestSubSequence(Node head) {
        ArrayList<Integer> dpList = new ArrayList<>();
        int maxSubSequence = 0;
        Node node = head;
        dpList.add(1);
        node = node.next;
        int countInner = 0;
        while (node != null) {
            countInner++;
            Node newNode = head;
            int countOuter = 0;
            while (newNode != node) {
                if (node.data > newNode.data) {
                    if (dpList.size() > countInner) {
                        dpList.set(countInner, Math.max(dpList.get(countInner), dpList.get(countOuter) + 1));
                    } else {
                        dpList.add(dpList.get(countOuter) + 1);
                    }
                } else {
                    dpList.add(1);
                }
                countOuter++;
                newNode = newNode.next;
            }
            maxSubSequence = Math.max(maxSubSequence, dpList.get(countInner));
            node = node.next;
        }
        System.out.println(maxSubSequence);
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
