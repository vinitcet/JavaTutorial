package com.vinit.example.linkedlist;

public class LinkedList {
    ListNode head;
    private int length;

    public LinkedList() {
        length = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode last = head;
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
            head = new ListNode(data);
        } else {
            ListNode temp = head;
            for (int i = 0; i < postion; i++) {
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            System.out.println(head.getData());
            length++;
        }
    }

    public ListNode removeFromBeginnig(LinkedList ls) {
        ListNode currentHead = ls.head;
        if (currentHead != null) {
            head = currentHead.getNext();
            currentHead.setNext(null);
        }
        return currentHead;
    }

    public synchronized ListNode removeFromEnd(){
        return null;
    }

    public void printLinkedList(LinkedList ls) {
        do {
            System.out.println(ls.head.getData());
            head = head.getNext();
        } while (head != null);

    }
}
