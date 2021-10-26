package com.vinit.example.apptio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {


    static class MyQueue {


        static Stack<Integer> firstStack = new Stack<>();
        static Stack<Integer> secondStack = new Stack<>();

        public static void enqueu(int i) {
            firstStack.add(i);
        }

        public static Integer dequeue() {
            if (firstStack.isEmpty()) {
                return -1;
            } else if (firstStack.size() == 1) {
                return firstStack.pop();
            } else {
                while (!firstStack.isEmpty()) {
                    secondStack.add(firstStack.pop());
                }
                int a = secondStack.pop();
                while (!secondStack.isEmpty()) {
                    firstStack.add(secondStack.pop());
                }
                return a;
            }
        }
    }

    public static void main(String[] args) {

        MyQueue mq = new MyQueue();
        mq.enqueu(1);
        mq.enqueu(2);
        mq.enqueu(3);
        mq.enqueu(4);
        mq.enqueu(5);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        mq.enqueu(6);
        mq.enqueu(7);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());

    }
}
