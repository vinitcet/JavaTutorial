package com.vinit.example.linkedlist;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ListNode ln = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
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
