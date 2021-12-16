package com.vinit.example.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FirstThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Runnable r2=()->{
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Lambda Thread: "+Thread.currentThread().getName());
        };
        thread.start();
        new Thread(r).start();
        new Thread(r2).start();
        System.out.println(Thread.currentThread().getName());
        Executor executor = Executors.newWorkStealingPool();
    }
}
