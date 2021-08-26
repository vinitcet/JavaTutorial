package com.vinit.example.sorco;

public class LinkedListTester {


    public static void main(String[] args) {
        MyLinkedList ls = new MyLinkedList();
        MyLinkedList.Node n1 = new MyLinkedList.Node("1");
        MyLinkedList.Node n2 = new MyLinkedList.Node("2");
        MyLinkedList.Node n3 = new MyLinkedList.Node("3");
        MyLinkedList.Node n4 = new MyLinkedList.Node("4");
        MyLinkedList.Node n5 = new MyLinkedList.Node("5");
        ls.insertAtBeginning(n1);
        ls.insertAtBeginning(n2);
        ls.insertAtEnd(n3);
        ls.insertAtEnd(n4);
        ls.insertAtBeginning(n5);
        for(int i=0;i<6;i++){
            ls.insertAtEnd(new MyLinkedList.Node(""+i));
        }
        //ls.print();
        // ls.removeFromBeginning();
        System.out.println("****New List *****");
        ls.print();
        System.out.println("****New List *****");
        //ls.deleteFromEnd();
        //ls.print();

       // ls.head =ls.reverse(ls.head);
        ls.removeduplicates();
        ls.print();
    }


}
