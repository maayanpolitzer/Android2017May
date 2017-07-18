package com.company;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Click me");
        btn1.setOnAction(new BtnClick(btn1));
        VBox layout = new VBox(btn1);
        Scene mainScene = new Scene(layout, 500, 500);
        primaryStage.setTitle("Maayan");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


}
