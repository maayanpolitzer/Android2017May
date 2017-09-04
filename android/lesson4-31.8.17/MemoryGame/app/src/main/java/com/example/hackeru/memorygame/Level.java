package com.example.hackeru.memorygame;

/**
 * Created by hackeru on 8/31/2017.
 */

public class Level {

    private int cols;
    private int rows;

    public Level(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
