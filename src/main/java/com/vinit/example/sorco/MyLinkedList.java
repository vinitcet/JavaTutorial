package com.vinit.example.sorco;

import java.util.HashSet;

public class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertAtBeginning(Node node) {
        node.next = head;
        this.head = node;
        size++;
    }

    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
        size++;
    }

    public void removeFromBeginning() {
        if (head == null) {
            System.out.println("List is empty, nothing ton delte");
        } else {
            Node currhead = head;
            head = head.next;
            currhead.next = null;
        }
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing ton delte");
        } else if (head.next == null) {
            head = null;
        } else {
            Node preNode = head;
            while (preNode.next.next != null) {
                preNode = preNode.next;
            }
            preNode.next = null;
        }
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

    boolean checkPalindrome(Node right) {
        Node left = head;
        if (right == null) {
            return true;
        }
        boolean ispal = checkPalindrome(right.next);
        if (ispal = false) {
            return false;
        }
        boolean isp = (right.data == left.data);
        left = left.next;
        return isp;
    }

    public void checkPlaindrome() {

    }

    public void removeduplicates() {
        // Hash to store seen values
        HashSet<String> hs = new HashSet<>();
        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null) {
            String curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("No element to print, please add something to print");
        } else {
            //Creating new node not to affect head;
            Node first = head;
            while (first != null) {
                System.out.println(first.data);
                first = first.next;
            }
        }
    }

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
