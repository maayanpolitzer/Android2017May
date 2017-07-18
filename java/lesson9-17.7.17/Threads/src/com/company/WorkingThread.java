package com.company;

/**
 * Created by hackeru on 7/17/2017.
 */
public class WorkingThread extends Thread {
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
