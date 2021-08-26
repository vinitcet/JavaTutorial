package com.vinit.example.list;

import java.util.Arrays;
import java.util.List;

public class LinkedListReverse {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;

        }
    }

    public void insertEnd(int data) {
        Node last = head;
        if (head == null) {
            head = new Node(data);
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(data);
        }
    }

    public void display() {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("Null");
    }

    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public void removeDuplicates() {
        Node node = head;
        while (node.next != null) {
            Node temp = node;
            while (temp != null && temp.data == node.data) {
                temp = temp.next;
            }
            node.next = temp;
            node = node.next;
        }
    }

    public Node revereseGroup(Node node, int size) {
        if (head == null) {
            return null;
        }
        Node current = node;
        Node next = null;
        Node previous = null;
        int len = 0;
        while (current != null && len < size) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            len++;
        }
        if (next != null) {
            node.next = revereseGroup(next, size);
        }

        node = previous;
        return node;
    }

    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        if (head == null) {
            return false;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) {
                return true;
            }
        }
        return false;
    }

    public void createLoop(int pos) {
        Node last = head;
        int size = 0;
        Node position = null;
        while (last.next != null) {
            last = last.next;
            size++;
            if (size == pos) {
                position = last;
            }
        }
        last.next = position;
    }

    public void displayLoop() {
        int count = 0;
        while (head != null && count < 15) {
            System.out.print(head.data + " -> ");
            head = head.next;
            count++;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedListReverse lr = new LinkedListReverse();
        List<Integer> myList = Arrays.asList(1, 2,9,1, 3, 8,6,4, 5, 6, 7, 8);
        for (int i : myList) {
            lr.insertEnd(i);
        }
        //lr.head = lr.reverse(lr.head);
        //lr.display();
        lr.removeDuplicates();
        //lr.head = lr.revereseGroup(lr.head, 2);
        lr.display();
      //  lr.createLoop(2);
        //System.out.println("Loop Created");
        //System.out.println("Loop Exist : " + lr.detectLoop());
        //lr.displayLoop();
    }
}
