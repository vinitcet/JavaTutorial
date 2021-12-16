package com.vinit.example.paypal;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.*/
public class MergeSortedLinkedList {


    public static void main(String[] args) {
//[[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] ls = {l1, l2, l3};
        ListNode output = mergeKLists(ls);
        while (output.next != null) {
            System.out.print(output.val + " -> ");
            output = output.next;
        }
        System.out.print(" X ");
        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(2);
        System.out.println();
        removeNthFromEnd(l4, 2);
        ListNode rev = reverseList(l1);
        while (rev.next != null) {
            System.out.print(rev.val + " -> ");
            rev = rev.next;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        // initial priorityQueue
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        //
        ListNode dummy = new ListNode(), tail = dummy;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            tail.next = top;
            tail = top;
            if (top.next != null) {
                pq.offer(top.next);
            }
        }

        return dummy.next;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;

        // 1) count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // check if value of n is not more than length of
        // the linked list
        if (len < n) {
            return head;
        } else if (len == n && n == 1) {
            return null;
        } else if (len == n) {
            return head.next;
        }

        temp = head;
        ListNode prev = null;
        // 2) get the (len-n+1)th node from the beginning
        for (int i = 1; i < len - n + 1; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (temp.next != null) {
            prev.next = temp.next;
        } else {
            prev.next = null;
        }


        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return prev;
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