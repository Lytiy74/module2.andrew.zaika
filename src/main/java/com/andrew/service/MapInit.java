package com.andrew.service;

import com.andrew.entities.organism.Entity;
import com.andrew.entities.organism.Organism;
import com.andrew.map.Cell;
import com.andrew.map.GameField;
import lombok.extern.log4j.Log4j2;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.reflections.Reflections.log;

@Log4j2
public class MapInit {
    private static MapInit instance;
    private GameField gameField = GameField.getInstance();
    private List<Class<?>> entitiesSet = new ArrayList<>(getAllEntityClasses());

    private MapInit() {
        log.info("Starting map init");
        fillGameField();
    }

    public static MapInit getInstance() {
        if (instance == null) {
            instance = new MapInit();
        }
        return instance;
    }

    private void fillGameField() {
        initCells(gameField.getCells());
        fillCells(gameField.getCells());
    }

    private void initCells(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                cells[row][column] = new Cell(row, column);
                log.info("Cell[" + row + "][" + column + "] was initialized. | "
                        + cells[row][column].toString());
            }
        }
    }

    private void fillCells(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                addRandomEntityToCell(cells[row][column]);
            }
        }
    }

    private void addRandomEntityToCell(Cell cell) {
        int cellMaxQuantity = cell.getMaxEntetiesQuantity();
        for (int i = 0; i < cellMaxQuantity; i++) {
            Class<?> randomEntityClass = getRandomEntity();
            try {
                Constructor<?> constructor = randomEntityClass.getConstructor();
                Organism entity = (Organism) constructor.newInstance();
                entity.setCell(cell);
                int maxQuantity = Math.min(entity.getMaxQuantity(), cell.getMaxEntetiesQuantity());
                int quantityToAdd = new Random().nextInt(maxQuantity + 1);
                for (int x = 0; x < quantityToAdd; x++) {
                    cell.addEntities(entity);
                }
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private Set<Class<?>> getAllEntityClasses() {
        Reflections reflections = new Reflections("com.andrew.entities.organism");
        Set<Class<?>> setOfClasses = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> item : setOfClasses) {
            log.info("Loaded entity class " + item.getSimpleName());
        }
        return setOfClasses;
    }

    private Class<?> getRandomEntity() {
        Random random = new Random();
        return entitiesSet.get(random.nextInt(entitiesSet.size()));
    }

}
