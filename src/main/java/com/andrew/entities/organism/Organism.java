package com.andrew.entities.organism;

import com.andrew.map.Cell;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.reflections.Reflections.log;

@Log4j2
public class Organism implements Reproducible {
    private Cell cell;
    private int maxQuantity;
    private int weight;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
    public void reproduce() {
        List<List<? extends Organism>> list = getCell().getEntities();
        Random random = new Random();

        List<Organism> originalEntities = new ArrayList<>();

        
        for (List<? extends Organism> listOfOrganism : list) {
            originalEntities.addAll(listOfOrganism);
        }

        List<Organism> newEntities = new ArrayList<>();

        for (Organism organism : originalEntities) {
            if (organism != this && this.getClass().isInstance(organism) && random.nextBoolean()) {
                try {
                    Organism newOrganism = this.getClass().getDeclaredConstructor().newInstance();
                    newOrganism.setCell(getCell());
                    newEntities.add(newOrganism);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        
        getCell().addEntities(newEntities);
    }
}
