package com.example.hackeru.whatsapp.server_connections;

import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 10/2/2017.
 */

public class HttpRequest extends Thread {

    private static final String SERVER_URL = "http://104.199.43.149/students/server";
    private JSONObject data;
    private HttpMethod method;
    private OnServerResponseListener listener;
    private Handler handler;

    public HttpRequest(HttpMethod method, JSONObject data, OnServerResponseListener listener){
        this.data = data;
        this.method = method;
        this.listener = listener;
        handler = new Handler();
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(SERVER_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method.toString());
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.getOutputStream().write(data.toString().getBytes());

            InputStream in = connection.getInputStream();
            byte[] buffer = new byte[128];
            StringBuilder sb = new StringBuilder();
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1){
                sb.append(new String(buffer, 0, actuallyRead));
            }
            final JSONObject input = new JSONObject(sb.toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess(input);
                }
            });
        } catch (MalformedURLException e) {
            publishFailure("wrong url...");
        } catch (IOException e) {
            publishFailure("no internet");
        } catch (JSONException e) {
            publishFailure("json parsing error");
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    private void publishFailure(final String error){
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailure(error);
            }
        });
    }
}
