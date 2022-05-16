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
            if (node == null)
                pre.next = null;
            else
                pre.next = node.next;
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
        n1 = insertInBegninning(n1, 2);
        insertAtEnd(n1, 9);
        insertAtPosition(n1, 3, 1);
        insertAtPosition(n1, 3, 1);
        insertAtPosition(n1, 3, 1);
        insertAfterNode(n1, 5, 6);
        insertAfterNode(n1, 5, 6);
        insertBeforeSinglePointer(n1, 9, 7);
        //n1 = deleteStart(n1);
        // MyLinkedList ml = new MyLinkedList();
        //ml.head = n1;
        //deleteFromPosition(n1, 24);
        display(n1);
        //System.out.println(isSorted(n1));
        removeDuplicates(n1);
        display(n1);
        display(reverse(n1));

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
        return "Node{" +
                "data=" + data +
                '}';
    }
}
