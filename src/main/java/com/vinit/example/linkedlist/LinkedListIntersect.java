package com.vinit.example.linkedlist;

import java.util.HashSet;

public class LinkedListIntersect {
    private Node head;
    private int size;

    public static void main(String[] args) {
        // list 1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        print(n1);
        print(n2);

        getIntersection(n1, n2);

    }

    static void getIntersection(Node n1, Node n2) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n1.next != null) {
            hashSet.add(n1.hashCode());
            n1 = n1.next;
        }
        while (n2.next != null) {
            if (hashSet.contains(n2.hashCode())) {
                System.out.println("The list meets at " + n2.data);
                break;
            } else {
                n2 = n2.next;
            }
        }
    }

    static void print(Node n) {
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
