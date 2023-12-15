package com.andrew.map;

import com.andrew.service.ConfigLoader;
import com.andrew.service.Logger;

public class GameField {
    private Logger logger = Logger.getInstance();
    private static final String PROPERTIES_KEY = "map.gamefield.";
    private static GameField instance;
    private int width;
    private int height;
    private Cell[][] cells;

    private GameField() {
        this.width = ConfigLoader.getIntProperty(PROPERTIES_KEY + "width");
        this.height = ConfigLoader.getIntProperty(PROPERTIES_KEY + "height");
        this.cells = new Cell[height][width];
        logger.log("gameField loaded");
    }

    public static GameField getInstance(){
        if (instance == null){
            instance = new GameField();
        }
        return instance;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
