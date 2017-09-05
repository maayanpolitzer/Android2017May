package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int SERVER_PORT = 10234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while(true) {
                System.out.println("waiting...");
                Socket socket = serverSocket.accept();  //  blocking method...
                System.out.println("client connected!");
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
