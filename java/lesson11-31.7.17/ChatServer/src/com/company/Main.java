package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int SERVER_PORT = 10234;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while(true){
                System.out.println("waiting...");
                Socket socket = serverSocket.accept();
                System.out.println("Client conected!");
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
