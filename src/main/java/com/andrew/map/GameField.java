package com.andrew.map;

import com.andrew.entities.organism.Organism;
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
    public void updateCell(Coordinates oldCoordinates, Coordinates newCoordinates, Organism organism){
        Cell oldCell = getCellAt(oldCoordinates.getX(), oldCoordinates.getY());
        Cell newCell = getCellAt(newCoordinates.getX(), newCoordinates.getY());
        if (oldCell != null){
            oldCell.removeEntity(organism);
        }
        if (newCell != null){
            newCell.addEntities(organism);
        }

    }
    private Cell getCellAt(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return cells[y][x];
        }
        return null;
    }
    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
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
