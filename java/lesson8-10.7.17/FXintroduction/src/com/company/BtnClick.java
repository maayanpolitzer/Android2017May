package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by hackeru on 7/10/2017.
 */
public class BtnClick implements EventHandler {

    private int counter;
    private Button btn;

    public BtnClick(Button btn){
        counter = 0;
        this.btn = btn;
    }

    // this method get called when i will click the button
    @Override
    public void handle(Event event) {
        counter++;
        btn.setText(counter + "");
    }
}
