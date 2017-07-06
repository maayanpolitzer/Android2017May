package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name:");
        String fileName = scanner.nextLine();
        fileName += ".txt";
        //createFile(fileName);
        //writeDataToFile(fileName, "this is the new content");
        //readFromFile(fileName);
        copyFile("image.jpg");
    }

    public static void copyFile(String srcFile){
        try {
            FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream("copy.jpg");
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) != -1){
                //ceaser encryption (XOR)
                /*
                for (int i = 0; i < buffer.length; i++){
                    buffer[i] ^= 2;
                }
                */
                out.write(buffer, 0, actuallyRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(String fileName){
        try {
            FileInputStream in = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];
            int actuallyRead;
            String data = "";
            while((actuallyRead = in.read(buffer)) != -1){
                String str = new String(buffer, 0, actuallyRead);
                data += str;
            }
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String fileName, String content){
        try {
            FileOutputStream out = new FileOutputStream(fileName, true);
            out.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String fileName){
        File file = new File(fileName);
        try {
            file.createNewFile();
            System.out.println(file.getAbsolutePath());
            System.out.println("DONE!!!");
        }catch(Exception e){
            System.out.println("Problem");
        }
    }
}
