package com.vinit.example.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node ln = new Node(1);
        Node ln2 = new Node(2);
        Node ln3 = new Node(3);
        Node ln4 = new Node(4);
        linkedList.head = ln3;
        linkedList.insertAtBegin(ln2);
        linkedList.insertAtBegin(ln);
        linkedList.insertAtEnd(ln4);
        linkedList.insertAfterData(2, 88);
        //linkedList.printLinkedList(linkedList);
        linkedList.removeFromBeginnig(linkedList);
        linkedList.printLinkedList(linkedList);

    }
}
