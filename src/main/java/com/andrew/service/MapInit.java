package com.andrew.service;

import com.andrew.entities.organism.Entity;
import com.andrew.entities.organism.Organism;
import com.andrew.map.Cell;
import com.andrew.map.GameField;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MapInit {
    private static MapInit instance;
    GameField gameField = GameField.getInstance();
    Logger logger = Logger.getInstance();

    private MapInit() {
        logger.log("Starting map init");
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
    private void initCells(Cell[][] cells){
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                cells[row][column] = new Cell();
            }
        }
    }
    private void fillCells(Cell[][] cells){
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                addRandomEntityToCell(cells[column][row]);
            }
        }
    }
    private void addRandomEntityToCell(Cell cell){
        Class<?> randomEntityClass = getRandomEntity();
        try {
            Constructor<?> constructor = randomEntityClass.getConstructor();
            cell.addEntities((Organism) constructor.newInstance());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Set<Class<?>> getAllEntityClasses() {
        Reflections reflections = new Reflections("com.andrew.entities.organism");
        Set<Class<?>> setOfClasses = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> item : setOfClasses) {
            logger.log("LOADED ENTITY CLASS " + item.getName());
        }
        return setOfClasses;
    }
    private Class<?> getRandomEntity(){
        List<Class<?>> entitiesSet = new ArrayList<>(getAllEntityClasses());
        Random random = new Random();
        return entitiesSet.get(random.nextInt(entitiesSet.size()));
    }

}
