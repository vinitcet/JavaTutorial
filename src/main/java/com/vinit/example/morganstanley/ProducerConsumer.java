package com.vinit.example.morganstanley;

import java.util.LinkedList;

public class ProducerConsumer {
    LinkedList<Integer> lst = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (lst.size() == capacity) {
                    wait();
                }
                System.out.println("Produced : " + value);
                lst.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (lst.size() == 0) {
                    wait();
                }
                int consume = lst.removeFirst();
                System.out.println("Consumed : " + consume);
                notify();
                Thread.sleep(100);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
