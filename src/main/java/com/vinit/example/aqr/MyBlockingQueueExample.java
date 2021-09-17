package com.vinit.example.aqr;

class MyBlockingQueue {
    int[] myQueue;
    int queueSize = 5;
    int lastPosition = -1;
    int head = -1;
    int elementsInQueue = 0;

    MyBlockingQueue(int size) {
        myQueue = new int[size];

    }

    public void push(int value) throws InterruptedException {
        synchronized (this) {
            //Queue is full
            while (elementsInQueue == queueSize) {
                wait();
            }
            if (elementsInQueue == 0) {
                notifyAll();
            }
            //Add logic
            if (lastPosition == queueSize - 1) {
                lastPosition = -1;
            }
            myQueue[++lastPosition] = value;
            elementsInQueue++;
        }
    }

    public int pop() throws InterruptedException {
        synchronized (this) {
            //Checking no element is there
            while (elementsInQueue < 1) {
                wait();
            }
            if (elementsInQueue == queueSize) {
                notifyAll();
            }
            //pop logic below
            if (head == queueSize - 1) {
                head = -1;
            }
            elementsInQueue--;
            int a = myQueue[++head];
            myQueue[head] = -1;
            return a;
        }
    }
}

public class MyBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        //array based fixed size queue
        // push and remove
        MyBlockingQueue queue = new MyBlockingQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        for (int i : queue.myQueue) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Value popped: " + queue.pop());
        System.out.println("Value popped: " + queue.pop());
        System.out.println("Value popped: " + queue.pop());
        queue.push(6);
        queue.push(7);
        for (int i : queue.myQueue) {
            System.out.print(i);
        }
    }
}