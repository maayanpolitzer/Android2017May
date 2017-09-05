package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by hackeru on 7/31/2017.
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        FileOutputStream fileOutputStream = null;
        try {
            InputStream socketInputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(System.currentTimeMillis() + ".jpg");
            int actuallyRead;
            byte[] buffer = new byte[1024];
            while ((actuallyRead = socketInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, actuallyRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
