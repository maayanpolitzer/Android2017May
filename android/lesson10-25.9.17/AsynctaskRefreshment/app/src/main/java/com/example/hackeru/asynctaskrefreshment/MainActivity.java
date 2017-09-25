package com.example.hackeru.asynctaskrefreshment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = new ProgressBar(this);

        DownloadThread t = new DownloadThread("http://www.one.co.il", progressBar);
        t.start();


        new DownloadTask(progressBar).execute(new String[]{"http://www.walla.co.il", "http:///www.msfgsvfkmsd"});

    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        private ProgressBar progressBar;

        public DownloadTask(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        @Override
        protected void onPreExecute() {
            // TODO: 9/25/2017 show the progressBar
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
                if (params[0] != null) {
                    url = new URL(params[0]);
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
                    publishProgress();
                }
                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            // TODO: 9/25/2017 hide the progress bar
            if (s == null) {
                // TODO: 9/25/2017 inform the user that an exception occurred...
            } else {
                Log.d("TAG", s);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
