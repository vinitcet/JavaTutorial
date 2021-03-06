package com.vinit.example.list;

import com.vinit.example.amazon.LinkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LinkedListLoop {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public void displayLoop() {
        int counter = 0;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
            if (counter == 15) {
                break;
            }
            counter++;
        }
        System.out.println("NULL");
    }

    public void addEnd(int data) {
        Node last = head;
        if (head == null) {
            head = new Node(data);
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(data);
        }
    }

    public boolean detectLoop() {
        if (head == null) {
            return false;
        } else {
            Node slow = head;
            Node fast = head.next;
            while (fast.next != null && fast.next.next != null) {
                if (slow.data == fast.data) {
                    System.out.println("Loop detected at :" + slow.data);
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
    public void removeLoop() {
        if (head == null) {

        } else {
            Node slow = head;
            Node fast = head.next;
            while (fast.next != null && fast.next.next != null) {
                if (slow.data == fast.data) {
                    System.out.println("Loop detected at :" + slow.data);
                    slow.next = null;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }

    public void createLoop(int pos) {
        Node last = head;
        int counter = 0;
        Node posNode = null;
        while (last.next != null) {
            if (counter == pos) {
                posNode = last;
            }
            last = last.next;
            counter++;
        }
        last.next = posNode;
    }

    public boolean detectLoopHashSet() {
        HashSet<Node> hs = new HashSet<>();
        Node n = head;
        while (n != null) {
            if (hs.contains(n)) {
                System.out.println("Loop found at : " + n.data);
                return true;
            } else {
                hs.add(n);
            }
            n = n.next;
        }
        return false;
    }

    public void removeLoopHashSet(Node n) {
        HashSet<Node> hs = new HashSet<>();
        Node prev = null;
        while (n != null) {
            if (hs.contains(n)) {
                System.out.println("Loop found at : " + n.data);
                prev.next = null;
                break;
            } else {
                hs.add(n);
                prev = n;
                n = n.next;
            }

        }
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    Node reverseBunch(Node head, int size) {
        if (head == null) {
            return null;
        }
        int count = 0;

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (count < size && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseBunch(next, size);
        }
        return prev;

    }

    static int i = 0;

    static void printNthFromLast(Node head, int n) {
        if (head == null)
            return;
        printNthFromLast(head.next, n);
        if (++i == n)
            System.out.print(head.data);
    }

    /* Function to get the nth node from the last of a
       linked list */
    void printNthFromLast(int n)
    {
        int len = 0;
        Node temp = head;

        // 1) count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // check if value of n is not more than length of
        // the linked list
        if (len < n)
            return;

        temp = head;

        // 2) get the (len-n+1)th node from the beginning
        for (int i = 1; i < len - n + 1; i++)
            temp = temp.next;

        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        LinkedListLoop ls = new LinkedListLoop();
        for (int i : dataList) {
            ls.addEnd(i);
        }
        //ls.display();
        // ls.createLoop(3);
        //ls.detectLoopHashSet();
        //ls.displayLoop();
        //ls.removeLoopHashSet(ls.head);
        //ls.display();
        //ls.head = ls.reverse(ls.head);
        //ls.display();
        printNthFromLast(ls.head, 6);
    }
}
