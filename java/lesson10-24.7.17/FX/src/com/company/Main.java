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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
        Button translateEngish = new Button("translate english");
        translateEngish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String word = englishTextField.getText();
                String t = translate(word);
                hebrewTextField.setText(t);
            }
        });
        HBox buttonsLayout = new HBox(btn,startBtn, translateEngish);
        VBox layout = new VBox(hebrewTextField, englishTextField, buttonsLayout);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String translate(String word){
        try {
            URL url = new URL("http://www.morfix.co.il/" + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead;
            String data = "";
            while((actuallyRead = in.read(buffer)) != -1){
                data += new String(buffer, 0, actuallyRead);
            }
            int from = data.indexOf("heTrans");
            if (from == -1){
                return "אין תרגום למילה " + word;
            }
            String s = data.substring(from + 9);
            int to = s.indexOf("<");
            String str = s.substring(0,to);
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "תקלה בתרגום המילה " + word;
    }
}
