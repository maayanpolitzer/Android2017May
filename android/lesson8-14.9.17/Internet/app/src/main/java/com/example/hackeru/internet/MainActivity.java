package com.example.hackeru.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://en.wikipedia.org/wiki/Android_version_history");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    int code = connection.getResponseCode(); // good: 200, bad : 404 - no such page/403 - auth problem /500 - internal error.
                    Log.d("Maayan", code + "");
                    InputStream in = connection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    int actuallyRead;
                    byte[] buffer = new byte[1024];
                    while((actuallyRead = in.read(buffer)) != -1){
                        sb.append(new String(buffer, 0, actuallyRead));
                    }
                    Log.d("Maayan", sb.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
