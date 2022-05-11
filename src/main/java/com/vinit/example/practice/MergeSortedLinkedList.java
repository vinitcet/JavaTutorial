package com.vinit.example.practice;

public class MergeSortedLinkedList {

    public static void main(String[] args) {


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode re = head;
        while (list1 != null || list2 != null) {
            if (list1.val <= list2.val) {
                head = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        while (list1 != null) {
            head = new ListNode(list1.val);
            list1 = list1.next;
            head = head.next;
        }
        while (list2 != null) {
            head = new ListNode(list2.val);
            list2 = list2.next;
            head = head.next;
        }
        return re;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
