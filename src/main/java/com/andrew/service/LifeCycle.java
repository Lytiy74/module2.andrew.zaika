package com.andrew.service;

import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.animal.Animal;
import com.andrew.map.Cell;
import com.andrew.map.GameField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LifeCycle {
   static GameField gameField = GameField.getInstance();
   static Cell[][] cells = gameField.getCells();
    public static void start(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                List<Organism> organisms = new ArrayList<>(cells[i][j].getEntities());

                Iterator<Organism> iterator = organisms.iterator();
                while (iterator.hasNext()) {
                    Organism organism = iterator.next();

                    if (organism instanceof Animal) {
                        Animal animal = (Animal) organism;
                        animal.move();
                    }

                    // Можливо, ви захочете додаткові перевірки та операції тут

                    // Під час ітерації через ітератор можна використовувати remove без помилок ConcurrentModificationException
                    iterator.remove();
                }

                // Оновити entities в клітині після ітерації
                cells[i][j].setEntities(organisms);
            }
        }
    }
}
