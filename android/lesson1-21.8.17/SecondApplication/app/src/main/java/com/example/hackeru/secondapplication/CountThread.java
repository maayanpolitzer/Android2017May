package com.example.hackeru.secondapplication;

import android.os.Handler;

/**
 * Created by hackeru on 8/21/2017.
 */

public class CountThread extends Thread {

    private MainActivity mainActivity;
    private Handler handler;

    public CountThread(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        handler = new Handler();
    }

    @Override
    public void run() {
        while(mainActivity.isWorking()){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    mainActivity.updateTV();
                }
            });
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
