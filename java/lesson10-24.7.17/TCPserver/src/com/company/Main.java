package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int PORT = 10236;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("waiting for clients...");
                try(
                    Socket clientSocket = serverSocket.accept() // blocking method.
                ) {
                    System.out.println("client connected!");
                    // get data from client
                    InputStream in = clientSocket.getInputStream();
                    int length = in.read(); // read one int. // blocking method.
                    byte[] data = new byte[length];
                    in.read(data); // blocking method.
                    System.out.println("username: " + new String(data));
                    // send data to client.
                    OutputStream out = clientSocket.getOutputStream();
                    String response = "OK";
                    out.write(response.length());
                    out.write(response.getBytes());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
