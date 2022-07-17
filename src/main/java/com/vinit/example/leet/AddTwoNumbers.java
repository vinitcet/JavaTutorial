package com.vinit.example.leet;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode ls = new ListNode(2);
        ls.next = new ListNode(4);
        ls.next.next = new ListNode(3);
        ListNode ls2 = new ListNode(5);
        ls2.next = new ListNode(6);
        ls2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers2(ls, ls2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode sumNode = null;
        ListNode result = null;
        int carry = 0;
        while (l1.next != null && l2.next != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            if (sumNode == null) {
                sumNode = new ListNode(sum);
                result = sumNode;
            } else {
                sumNode.next = new ListNode(sum);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next != null) {
            int sum = l1.val + carry;
            if (sum > 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            sumNode.next = new ListNode(sum);
        }
        if (l2.next != null) {
            int sum = l2.val + carry;
            if (sum > 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            sumNode.next = new ListNode(sum);
        }
        return result;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;

    }
}

