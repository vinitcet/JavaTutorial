package com.vinit.example.linkedlist;

public class LinkedList {
    Node head;
    private int length;

    public LinkedList() {
        length = 0;
    }

    public Node getHead() {
        return head;
    }

    public synchronized void insertAtBegin(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        length++;
    }

    public synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
        length++;
    }

    public void insertAfterData(int postion, int data) {
        if (postion < 0) {
            postion = 0;
        } else if (postion > length) {
            postion = length;
        }
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            for (int i = 0; i < postion; i++) {
                temp = temp.getNext();
            }
            Node newNode = new Node(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            System.out.println(head.getData());
            length++;
        }
    }

    public Node removeFromBeginnig(LinkedList ls) {
        Node currentHead = ls.head;
        if (currentHead != null) {
            head = currentHead.getNext();
            currentHead.setNext(null);
        }
        return currentHead;
    }

    public synchronized Node removeFromEnd() {
        return null;
    }

    public void printLinkedList(LinkedList ls) {
        do {
            System.out.println(ls.head.getData());
            head = head.getNext();
        } while (head != null);

    }
}
