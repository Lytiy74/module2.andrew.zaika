package com.andrew;

import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.animal.Animal;
import com.andrew.map.Cell;
import com.andrew.map.GameField;
import com.andrew.service.LifeCycle;
import com.andrew.service.MapInit;

public class Main {
    public static void main(String[] args) {
        MapInit.getInstance();
        GameField gameField = GameField.getInstance();
        Cell[][] cells = gameField.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                System.out.println(cells[row][column].toString());
            }
        }
        LifeCycle.start();
    }
}