package com.andrew.map;

public class GameField {
    private int width;
    private int height;
    private Cell[][] cells;

    public GameField(int width, int height, Cell[][] cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
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
}
