package com.vinit.example.amazon;

public class LinkedList {
    Node head;

    void insertFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    Node reverse(Node head) {
        if (head == null) {
            System.out.println("Linked list is blank");
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    Node reverseBunch(Node head, int size) {
        if (head == null) {
            return null;
        }
        int count = 0;

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (count < size && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseBunch(next, size);
        }
        return prev;

    }

    void display(Node head) {
        Node readHead = head;
        if (readHead == null) {
            System.out.print("Linked list is blank");
        } else {
            while (readHead != null) {
                System.out.print(readHead.data + " -> ");
                readHead = readHead.next;
            }
        }
        System.out.println("NUll");
    }


    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.insertFirst(1);
        ls.insertFirst(2);
        ls.insertFirst(3);
        ls.insertFirst(4);
        ls.insertFirst(5);
        ls.insertFirst(6);
        ls.insertFirst(7);
        ls.insertFirst(8);
        ls.insertFirst(9);
        ls.display(ls.head);
        //ls.display(ls.reverse(n));
        ls.display(ls.reverseBunch(ls.head, 3));

    }
}
