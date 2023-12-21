package com.andrew;

import com.andrew.map.Cell;
import com.andrew.map.GameField;
import com.andrew.service.LifeCycle;
import com.andrew.service.MapInit;
import lombok.extern.log4j.Log4j2;

import static org.reflections.Reflections.log;


@Log4j2
public class Main {
    public static void main(String[] args) {
        MapInit.getInstance();
        GameField gameField = GameField.getInstance();
        Cell[][] cells = gameField.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                log.info(cells[row][column].toString());
            }
        }
    }
}