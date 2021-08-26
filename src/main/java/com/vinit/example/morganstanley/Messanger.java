package com.vinit.example.morganstanley;

public class Messanger<N extends Number> implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Messanger("wallet"));
        t1.start();
       // t1.start();
        t1.run();
        t1.run();
        //new Thread(new Messanger("groom")).start();
    }

    private String name;

    public Messanger(String name) {
        this.name = name;
    }


    public void run() {
        message(1);
        message(2);
    }

    private synchronized void message(int n) {
        System.out.println(name + "-" + n + " "+Thread.currentThread().getName());

    }
}
