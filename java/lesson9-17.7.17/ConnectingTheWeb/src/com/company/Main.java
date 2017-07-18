package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {



        try {
            URL url = new URL("https://weather.com/weather/today/l/ISXX0022:1:IS");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            byte[] buffer = new byte[128];
            int actuallyRead;
            String data = "";
            while((actuallyRead = in.read(buffer)) != -1){
                String str = new String(buffer, 0, actuallyRead);
                if (str.contains("nowcard-temp\"><span class=\"\">")){
                    String tempTemp = str.split("\"\">")[1];
                    tempTemp = tempTemp.substring(0, tempTemp.indexOf("<"));
                    double temp = (Integer.parseInt(tempTemp) -32) * 5 / 9;
                    System.out.printf("It's " + temp + " degrees out there!!!");
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("url incorrect");
        } catch (IOException e) {
            System.out.println("no internet connection/server is down");
        }

    }
}
