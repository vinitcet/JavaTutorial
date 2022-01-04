package com.vinit.example.leet;

/*
Given the head of a sorted linked list, delete all duplicates such that each element
 appears only once. Return the linked list sorted as well.*/
public class LinkedListLeet {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (prev != null && prev.val == node.val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
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
