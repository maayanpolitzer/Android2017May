package com.example.hackeru.asynctaskrefreshment;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hackeru on 9/25/2017.
 */

public class DownloadThread extends Thread {

    private Handler handler;
    private String link;
    private ProgressBar progressBar;

    public DownloadThread(String link, ProgressBar progressBar){
        handler = new Handler();
        this.link = link;
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        URL url = null;
        try {
            if (link != null) {
                url = new URL(link);
            } else {
                url = new URL("http://www.one.co.il");
            }
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead;
            StringBuilder sb = new StringBuilder();
            while ((actuallyRead = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, actuallyRead));
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // publish progress...
                    }
                });
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    // TODO: 9/25/2017 handle the string...
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
