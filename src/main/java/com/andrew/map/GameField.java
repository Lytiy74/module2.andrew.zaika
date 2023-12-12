package com.andrew.map;

public class GameField {
    private GameField instance;
    private int width;
    private int height;
    private Cell[][] cells;

    private GameField(int width, int height,Cell[][] cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public GameField getInstance(int width,int height, Cell[][] cells){
        if (instance == null){
            instance = new GameField(width, height, cells);
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
