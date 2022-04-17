package com.vinit.example.leet;

public class SwapLinkedListNode {


    public static void main(String[] args) {
        ListNode ls = new ListNode(2);
        ls.next = new ListNode(3);
        ls.next.next = new ListNode(4);
        ls.next.next.next = new ListNode(5);
        //print(ls);
        //print(reverse(ls));
        print(swapNodes(ls, 1));
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println(" X ");
    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode startHead = head;
        ListNode s = head;
        int kstart = k;
        ListNode start = head;

        while (kstart != 1) {
            head = head.next;
            kstart--;
        }
        int temp = head.val;
        ListNode check = head;

        while (head.next != null) {
            head = head.next;
            s = s.next;
        }

        check.val = s.val;
        s.val = temp;

        return startHead;

    }

}