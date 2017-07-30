package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application{

    private Stage window;
    private String name;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setScene(new Scene(firstScreen(), 300, 300));
        primaryStage.show();
    }

    private VBox mainScreen(){
        TextArea chatView = new TextArea();
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
                    chatView.appendText(name + ": " + message + "\n");
                    input.setText("");
                }
            }
        });
        HBox bottomLayout = new HBox(input, sendBtn);
        return new VBox(chatView, bottomLayout);
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
