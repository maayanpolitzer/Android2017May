package com.company;

public class Main {

    public static void main(String[] args) {

        X x = new X();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    x.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    x.increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();  // the mainThread wait until t1 will finish
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(x.getNumber());

    }
}
