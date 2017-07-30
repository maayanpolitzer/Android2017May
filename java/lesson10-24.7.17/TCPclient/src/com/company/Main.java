package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final String SERVER_IP = "10.0.16.49";
    private static final int SERVER_PORT = 10236;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String data = scanner.nextLine();   // blocking method!
        try (
                Socket socket = new Socket(SERVER_IP, SERVER_PORT)
        ){
            OutputStream out = socket.getOutputStream();
            out.write(data.length());
            out.write(data.getBytes());
            InputStream in = socket.getInputStream();
            int length = in.read();
            byte[] buffer = new byte[length];
            in.read(buffer);
            System.out.println("server response: " + new String(buffer));
        }catch (IOException e){
            e.printStackTrace();
        }
        /*
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            OutputStream out = socket.getOutputStream();
            out.write(data.length());
            out.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        */
    }
}
