package com.vinit.example.list;

import java.util.Stack;

public class DeleteSumZero {

    public LinkedList removeZeroNodes(LinkedList ls) {
        if (ls.head == null) {
            return ls;
        }
        LinkedList.Node head = ls.head;
        Stack<LinkedList.Node> internalStack = new Stack<>();
        while (head != null) {
            internalStack.push(head);
            int sum = 0;
            for (LinkedList.Node n : internalStack) {
                sum = sum + n.data;
            }
            if (sum == 0) {
                internalStack.removeAllElements();
            }
            head = head.next;
        }
        for (LinkedList.Node i : internalStack) {
            System.out.println(i.data);
        }
        return ls;
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        int arr[]={6, -6, 8, 4, -12, 9, 8, -8};
    }
}
