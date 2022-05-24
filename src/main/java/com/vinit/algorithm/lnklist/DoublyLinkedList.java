package com.vinit.algorithm.lnklist;

public class DoublyLinkedList {
    DoublyNode head;

    public static void insertInEnd(DoublyNode head, int data) {
        DoublyNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        DoublyNode newNode = new DoublyNode(data);
        newNode.prev = node;
        node.next = newNode;
    }

    public static int lengthOfDL(DoublyNode head) {
        DoublyNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static DoublyNode insertAtPosition(DoublyNode node, int pos, int data) {
        DoublyNode head = node;
        if (pos < 0) {
            pos = 0;
        }
        if (pos > lengthOfDL(node)) {
            pos = lengthOfDL(node);
        }
        DoublyNode newNode = new DoublyNode(data);
        if (node == null) {
            head = newNode;
        }
        if (pos == 0) {
            node.prev = newNode;
            newNode.next = node;
            head = newNode;
        } else {
            if (pos > lengthOfDL(node)) {
                pos = lengthOfDL(node);
            }
            for (int i = 0; i < pos - 1; i++) {
                node = node.next;
            }
            newNode.prev = node;
            if (node.next != null) {
                newNode.next = node.next;
                node.next.prev = newNode;
            }
            node.next = newNode;
        }
        return head;
    }

    public static DoublyNode deleteNode(DoublyNode node, int pos) {
        pos = pos < 0 ? 0 : pos;
        pos = pos > lengthOfDL(node) ? lengthOfDL(node) - 1 : pos;
        if (node == null) {
            return node;
        }
        DoublyNode head = node;
        if (pos == 0) {
            head = head.next;
            head.prev = null;
            node = head;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                head = head.next;
            }
            if (head.next.next == null) {
                head.next = null;
            } else {
                DoublyNode p = head;
                head.next = head.next.next;
                head.next.prev = p;
            }
        }
        return node;
    }

    public static DoublyNode reverse(DoublyNode node) {
        DoublyNode temp = null;
        DoublyNode current = node;
        DoublyNode head = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    public static void display(DoublyNode node) {
        if (node != null) {
            System.out.print(node.data + " -> ");
            display(node.next);
        }
    }

    public static void displayReverse(DoublyNode node) {
        while (node.next != null) {
            node = node.next;
        }
        while (node != null) {
            System.out.print(node.data + " <- ");
            node = node.prev;
        }
    }

    public static int getMiddle(DoublyNode node) {
        DoublyNode middle = node;
        DoublyNode last = node;
        while (last.next != null && last.next.next != null) {
            last = last.next.next;
            middle = middle.next;
        }
        return middle.data;
    }


    public static void main(String[] args) {
        DoublyNode dn = new DoublyNode(5);
        insertInEnd(dn, 6);
        insertInEnd(dn, 7);
        insertInEnd(dn, 8);
        dn = insertAtPosition(dn, 0, 2);
        dn = insertAtPosition(dn, 0, 1);
        dn = insertAtPosition(dn, 2, 3);
        dn = insertAtPosition(dn, 3, 4);
        dn = insertAtPosition(dn, 15, 10);
        display(dn);
        System.out.println();
        System.out.println("Middle " + getMiddle(dn));
        dn = deleteNode(dn, 0);
        dn = deleteNode(dn, 15);
        dn = deleteNode(dn, 3);
        display(dn);
        System.out.println();
        System.out.println("Middle " + getMiddle(dn));
        displayReverse(dn);
        System.out.println();
        System.out.println("Middle " + getMiddle(dn));
        dn = reverse(dn);
        display(dn);
    }


}

class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
    }
}