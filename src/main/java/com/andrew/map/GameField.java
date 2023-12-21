package com.andrew.map;

import com.andrew.entities.organism.Organism;
import com.andrew.service.ConfigLoader;
import static org.reflections.Reflections.log;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GameField {
    private static final String PROPERTIES_KEY = "map.gamefield.";
    private static GameField instance;
    private int width;
    private int height;
    private Cell[][] cells;

    private GameField() {
        this.width = ConfigLoader.getIntProperty(PROPERTIES_KEY + "width");
        this.height = ConfigLoader.getIntProperty(PROPERTIES_KEY + "height");
        this.cells = new Cell[height][width];
        log.info("gameField loaded");
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
    public Cell getCellAt(int x, int y) {
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
