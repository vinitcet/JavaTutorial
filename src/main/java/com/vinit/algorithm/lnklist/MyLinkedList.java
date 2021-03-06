package com.vinit.algorithm.lnklist;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {
    private static Node head;

    public static void display(Node node) {
        Node head = node;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("X");
    }

    public static void displayRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " -> ");
            displayRecursive(node.next);
        }
    }

    public static void displayRecursiveReverse(Node node) {
        if (node != null) {
            displayRecursiveReverse(node.next);
            System.out.print(node.data + " <- ");
        }
    }

    public static int countElements(Node node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static int countElementRecursive(Node node) {
        if (node != null) {
            return countElementRecursive(node.next) + 1;
        } else {
            return 0;
        }
    }

    public static int sumElements(Node node) {
        int sum = 0;
        while (node != null) {
            sum += node.data;
            node = node.next;

        }
        return sum;
    }

    public static int sumElementRecursive(Node node) {
        if (node != null) {
            return node.data + sumElements(node.next);
        } else {
            return 0;
        }
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;
        while (node != null) {
            if (node.data > m) {
                m = node.data;
                node = node.next;
            }
        }
        return m;
    }

    public static int maxRecursive(Node node) {
        int x = 0;
        if (node != null) {
            x = maxRecursive(node.next);
            return x > node.data ? x : node.data;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static Node search(Node node, int data) {
        while (node != null) {
            if (data == node.data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static Node searchRecursive(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }
        return searchRecursive(node.next, data);
    }

    public static Node insertInBegninning(Node node, int val) {
        Node n = new Node(val);
        n.next = node;
        node = n;
        return n;
    }

    public static void insertAtEnd(Node node, int val) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(val);
    }

    public static void insertAtPosition(Node node, int pos, int val) {
        for (int i = 0; i < pos - 2; i++) {
            node = node.next;
        }
        Node nn = new Node(val);
        nn.next = node.next;
        node.next = nn;
    }

    public static void insertAfterNode(Node node, int pre, int val) {
        while (node != null) {
            if (node.data == pre) {
                Node nn = new Node(val);
                nn.next = node.next;
                node.next = nn;
                break;
            }
            node = node.next;
        }
    }

    public static void insertBeforeSinglePointer(Node node, int pre, int val) {
        while (node != null && node.next != null) {
            if (node.next.data == pre) {
                Node nn = new Node(val);
                nn.next = node.next;
                node.next = nn;
                break;
            }
            node = node.next;
        }
    }

    public static Node deleteStart(Node node) {
        if (node != null) {
            node = node.next;
        }
        return node;
    }

    public static void deleteFromPosition(Node node, int pos) {

        if (pos <= 0) {
            node = node.next;
        } else {
            Node pre = null;
            for (int i = 0; i < pos - 2 && node.next != null; i++) {
                pre = node;
                node = node.next;
            }
            if (node == null) pre.next = null;
            else pre.next = node.next;
        }
    }

    public static boolean isSorted(Node node) {
        int min = Integer.MIN_VALUE;
        while (node != null) {
            if (min > node.data) {
                return false;
            }
            min = node.data;
            node = node.next;
        }

        return true;
    }

    public static void removeDuplicatesSorted(Node node) {
        Node prev = null;
        while (node != null) {
            if (prev.data == node.data) {
                prev.next = node.next;
                node = node.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
    }

    public static void removeDuplicates(Node node) {
        Set<Integer> dup = new HashSet<>();
        Node prev = null;
        while (node != null) {
            if (dup.contains(node.data)) {
                prev.next = node.next;
            } else {
                dup.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }

    public static Node reverse(Node n1) {
        Node prev = null;
        Node next = null;
        Node cur = n1;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void reverseRecursive(Node n2, Node node) {
        if (node != null) {
            reverseRecursive(node, node.next);
            node.next = n2;
        } else {
            head = n2;
        }
    }

    public static Node mergeSorted(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        Node third;
        Node last;
        if (n1.data < n2.data) {
            third = last = n1;
            n1 = n1.next;
            last.next = null;
        } else {
            third = last = n2;
            n2 = n2.next;
            last.next = null;
        }
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                last.next = n1;
                last = n1;
                n1 = n1.next;
                last.next = null;
            } else {
                last.next = n2;
                last = n2;
                n2 = n2.next;
                last.next = null;
            }
        }
        if (n1 != null) {
            last.next = n1;
        } else {
            last.next = n2;
        }
        return third;
    }

    public static Node mergeSortedRecursion(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.data < n2.data) {
            n1.next = mergeSortedRecursion(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeSortedRecursion(n1, n2.next);
            return n2;
        }
    }

    public static boolean checkLoop(Node node) {

        if (node == null) {
            return false;
        }
        Node fast = node;
        Node slow = node;

        while (null != slow.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void displayCircular(Node node) {
        Node head = node;
        do {
            System.out.print(head.data + " -> ");
            head = head.next;
        } while (head != node);

        System.out.println("X");
    }

    private static int pos = 0;

    public static void displayCircularRecursive(Node node) {
        Node head = node;
        while (node != head || pos != 0) {
            System.out.println(node.data);
            display(node.next);
        }
    }

    public static void insertCircular(Node node, int pos, int data) {
        Node head = node;
        Node node1 = new Node(data);
        if (head == null) {
            head = node1;
            node1.next = head;
        }
        if (pos <= 0) {
            node1.next = head;
            while (head.next != head) {
                head = head.next;
            }
            head.next = node1;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                head = head.next;
            }
            node1.next = head.next;
            head.next = node1;
        }
    }

    public static void deleteCircular(Node node, int pos) {
        Node head = node;
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
        }
        if (pos == 0) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = node.next;
        } else {
            for (int i = 0; i < pos - 2; i++) {
                head = head.next;
            }
            head.next = head.next.next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.next = new Node(4);
        n1.next.next = new Node(5);
        //display( n1 );
        Node test = n1;
        //displayRecursive( test );
        //displayRecursiveReverse( n1 );
        // System.out.println( countElements( n1 ) );
        // System.out.println( countElementRecursive( test ) );
        //System.out.println( sumElements( n1 ) );
        //System.out.println( sumElementRecursive( test ) );4
        // System.out.println( maxRecursive( test ) );
        // System.out.println( max( n1 ) );
        // System.out.println(searchRecursive(test, 3).toString());
        //System.out.println(search(n1, 3).toString());
//        n1 = insertInBegninning(n1, 2);
//        insertAtEnd(n1, 9);
//        insertAtPosition(n1, 3, 1);
//        insertAtPosition(n1, 3, 1);
//        insertAtPosition(n1, 3, 1);
//        insertAfterNode(n1, 5, 6);
//        insertAfterNode(n1, 5, 6);
//        insertBeforeSinglePointer(n1, 9, 7);
        //n1 = deleteStart(n1);
        //deleteFromPosition(n1, 24);
        //display(n1);
        //System.out.println(isSorted(n1));
//        removeDuplicates(n1);
//        display(n1);
//        MyLinkedList ml = new MyLinkedList();
//        ml.head = n1;
//        reverseRecursive(null, n1);
//        display(ml.head);
        Node s1 = new Node(2);
        insertAtEnd(s1, 8);
        insertAtEnd(s1, 10);
        insertAtEnd(s1, 15);
        Node s2 = new Node(5);
        insertAtEnd(s2, 7);
        insertAtEnd(s2, 12);
        insertAtEnd(s2, 14);
        display(s1);
        display(s2);
        display(mergeSortedRecursion(s1, s2));
    }


}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
