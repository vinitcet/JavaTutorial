package com.vinit.example.list;

public class
LinkedList {
    Node head;

    void printMiddle() {
        Node slow = head;
        Node fast = head;
        if (head != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println("The middle element is: " + slow.data);
        }
    }

    public void insertAtBeginning(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void printLinkedList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        for (int i = 0; i < 5; i++) {
            ls.insertAtBeginning(i);
            ls.printLinkedList();
            ls.printMiddle();
        }
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;

        }
    }
}

