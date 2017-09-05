package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hackeru on 7/31/2017.
 */
public class ClientThread extends Thread{

    private Socket socket;
    private static ArrayList<String> messages = new ArrayList<>();

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
            InputStream in = socket.getInputStream()
        ){
            int action = in.read();
            switch(action){
                case 1:
                    //client send message
                    System.out.println("************************** SEND MESSAGE ******************** " + messages.size());
                    int length = in.read();
                    byte[] buffer = new byte[length];
                    in.read(buffer);
                    String messageFromClient = new String(buffer);
                    messages.add(messageFromClient);
                    break;
                case 2:
                    // client get message.
                    OutputStream out = socket.getOutputStream();
                    int messagesInClient = in.read();
                    if (messagesInClient < messages.size()){
                        out.write(messages.get(messagesInClient).length());
                        out.write(messages.get(messagesInClient).getBytes());
                    }else{
                        out.write(0);
                    }
                    break;
                case 3:


                    break;
                default:


            }
        }catch(IOException e){

        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
