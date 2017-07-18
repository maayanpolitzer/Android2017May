package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> invitationsList = new ArrayList<>();
    private static boolean running = true;

    public static void main(String[] args) {
        getDataFromFile();
        Scanner scanner = new Scanner(System.in);
        while(running){
            System.out.println("Welcome to my party... what is your name?");
            String str = scanner.nextLine();    // blocking method!!!
            if (str.equals("EXIT")){
                running = false;
            }else if(str.isEmpty()){
                System.out.println("Why like this?!?!?!");
            }else{
                if (invitationsList.contains(str)){
                    System.out.println("Already in the list!");
                }else{
                    invitationsList.add(str);
                    System.out.println("Just added");
                }
            }
        }
        saveDataToFile();
    }

    private static void getDataFromFile(){
        try {
            // get data from the file.
            FileInputStream in = new FileInputStream("temp.txt");
            byte[] buffer = new byte[1024];
            int actuallyRead;
            String data = "";
            while((actuallyRead = in.read(buffer)) != -1){
                data += new String(buffer, 0, actuallyRead);
            }
            // String manipulation - try to understand what is written.
            data = data.substring(1, data.length()-1);
            String[] arr = data.split(", ");

            // insert the array data into invitationsList ArrayList.
            for (int i = 0; i < arr.length; i++){
                invitationsList.add(arr[i]);
            }
        } catch (Exception e) {

        }
    }

    private static void saveDataToFile(){
        File file = new File("temp.txt");
        if (!file.exists()){
            try {
                // create a file in NOT already exists.
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // convert arrayList to String.
        String content = invitationsList.toString();
        try {
            // write the data to the file.
            FileOutputStream out = new FileOutputStream(file);
            out.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
