package com.company;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Main extends Application{

    private static final String SERVER_IP = "10.0.16.49";
    private static final int SERVER_PORT = 10234;

    private Stage window;
    private String name;

    private int messagesCounter;
    private TextArea chatView;

    private boolean screenOn = true;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                screenOn = false;
            }
        });
        window = primaryStage;
        primaryStage.setScene(new Scene(firstScreen(), 300, 300));
        primaryStage.show();

    }

    private VBox mainScreen(){
        chatView = new TextArea();
        chatView.setPrefSize(500, 400);
        chatView.setEditable(false);

        TextField input = new TextField();
        input.setPrefSize(400, 100);
        input.setAlignment(Pos.TOP_LEFT);
        input.setPromptText("Enter your message");

        Button sendBtn = new Button("Send");
        sendBtn.setPrefSize(100, 100);
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    String message = input.getText().trim();
                    if (!message.isEmpty()){
                        String content = name + ": " + message + "\n";
                        sendMessage(content);
                        input.setText("");
                    }
            }
        });
        HBox bottomLayout = new HBox(input, sendBtn);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (screenOn){
                    syncDataFromServer();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return new VBox(chatView, bottomLayout);

    }

    private void syncDataFromServer(){
        try(
            Socket socket = new Socket(SERVER_IP, SERVER_PORT)// connect to the server.
        ){
            OutputStream out = socket.getOutputStream();// send data from this program to the server
            out.write(2); // let the server know that we want to GET a message (action)
            out.write(messagesCounter);
            InputStream in = socket.getInputStream();
            int response = in.read();
            if (response > 0){
                byte[] buffer = new byte[response];
                in.read(buffer);
                String message = new String(buffer);
                messagesCounter++;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        chatView.appendText(message);
                    }
                });
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void sendMessage(String content){
        try(
                Socket socket = new Socket(SERVER_IP, SERVER_PORT)  // connect to the server.
                ){
            OutputStream out = socket.getOutputStream();    // send data from this program to the server
            out.write(1);       // let the server know that we will send a message (action)
            out.write(content.length());
            out.write(content.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private VBox firstScreen(){
        Label label = new Label("Enter your name");
        TextField input = new TextField();
        Button startBtn = new Button("START CHATTING");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                name = input.getText();
                if (!name.isEmpty()) {
                    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                    /*
                    char first = name.charAt(0);
                    if (first >= 97 && first <= 122){
                        char newFirst = (char)(first - 32);
                        name = name.replaceFirst(String.valueOf(first), String.valueOf(newFirst));
                    }
                    */
                    window.setScene(new Scene(mainScreen()));
                }
            }
        });
        return new VBox(label, input, startBtn);
    }

}
