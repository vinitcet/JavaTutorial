package com.vinit.example.morganstanley;

import org.springframework.transaction.PlatformTransactionManager;

import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Executing thread: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            ex.execute(t1);
            System.out.println("Submitting task");
        }
        ex.shutdown();

    }
}
