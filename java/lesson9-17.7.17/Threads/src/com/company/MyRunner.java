package com.company;

/**
 * Created by hackeru on 7/17/2017.
 */
public class MyRunner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("from runner " + i);
        }
    }
}
