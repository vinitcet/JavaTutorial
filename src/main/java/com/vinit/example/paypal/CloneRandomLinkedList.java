package com.vinit.example.paypal;
/*A linked list of length n is given such that each node contains an additional random pointer,
 which could point to any node in the list, or null.

  Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has
  its value set to the value of its corresponding original node.
  Both the next and random pointer of the new nodes should point to new nodes in the copied
  list such that the pointers in the original list and copied list represent the same list state.
   None of the pointers in the new list should point to nodes in the original list.*/
public class CloneRandomLinkedList {

    /* Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List,
     create a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after the Nth node

     Now copy the random link in this fashion

     original->next->random= original->random->next;  *//*TRAVERSE  TWO NODES*//*
    This works because original->next is nothing but a copy of the original and Original->random->next is nothing but a copy of the random.

    Now restore the original and copy linked lists in this fashion in a single loop.

    original->next = original->next->next;
    copy->next = copy->next->next;

    Ensure that original->next is NULL and return the cloned list*/
    static class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
            random = null;
            next = null;
        }
    }

    static void print(Node root) {
        Node start = root;
        while (start != null) {
            System.out.println("Data = " + start.data
                    + ", Random = "
                    + start.random.data);
            start = start.next;
        }
    }

    static Node clone(Node start) {
        Node curr = start, temp = null;

        // insert additional node after
        // every node of original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = start;

        // adjust the random pointers of the
        // newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null)
                        ? curr.random.next
                        : curr.random;

            // move to the next newly added node by
            // skipping an original node
            curr = curr.next.next;
        }

        Node original = start, copy = start.next;

        // save the start of copied linked list
        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.next =original.next.next;

            copy.next = (copy.next != null) ? copy.next.next
                    : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
    public static void main(String[] args)
    {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = clone(start);
        print(cloned_list);
    }
}
