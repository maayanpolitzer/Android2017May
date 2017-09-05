package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    private static final String SERVER_IP = "10.0.16.49";
    private static final int SERVER_PORT = 10235;

    public static void main(String[] args) {
        File imageFile = new File("image.jpg");
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            FileInputStream fileInputStream = new FileInputStream(imageFile);
            OutputStream socketOutputStream = socket.getOutputStream();
            int actuallyRead;
            byte[] buffer = new byte[1024];
            while((actuallyRead = fileInputStream.read(buffer)) != -1){
                socketOutputStream.write(buffer, 0, actuallyRead);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
