package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Word[] words = {
            new Word("כלב", "Dog"),
            new Word("חתול", "Cat"),
            new Word("יום", "Day")
    };
    private int counter;
    private Button startBtn;
    private boolean working;
    private EventHandler btnClickHandler = new EventHandler() {
        @Override
        public void handle(Event event) {
            if (!working){
                startBtn.setText("Stop");
                working = true;
            }else{
                startBtn.setText("Start");
                working = false;
            }
        }
    };

    public static void main(String[] args) {
	    launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField hebrewTextField = new TextField();
        TextField englishTextField = new TextField();

        Button btn = new Button("next");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hebrewTextField.setText(words[counter].getHebrew());
                englishTextField.setText(words[counter].getEnglish());
                counter++;
                if (counter == words.length){
                    counter = 0;
                }
            }
        });
        startBtn = new Button("Start");
        startBtn.setOnAction(btnClickHandler);
        HBox buttonsLayout = new HBox(btn,startBtn);
        VBox layout = new VBox(hebrewTextField, englishTextField, buttonsLayout);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
