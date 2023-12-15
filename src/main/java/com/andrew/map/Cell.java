package com.andrew.map;

import com.andrew.entities.organism.Organism;
import com.andrew.service.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private static final String PROPERTIES_KEY = "map.cell.";
    private List<Organism> entities = new ArrayList<>();
    private int maxEntetiesQuantity;


    public void setMaxEntetiesQuantity(int maxEntetiesQuantity) {
        this.maxEntetiesQuantity = maxEntetiesQuantity;
    }

    public Cell() {
        this.maxEntetiesQuantity = ConfigLoader.getIntProperty(PROPERTIES_KEY + "max-entities-quantity");
    }

    public int getMaxEntetiesQuantity() {
        return maxEntetiesQuantity;
    }

    public Cell(List<Organism> entities) {
        this.entities = entities;
    }

    public void setEntities(List<Organism> entities) {
        this.entities = entities;
    }

    public void addEntities(Organism entities) {
        this.entities.add(entities);
    }

    public void removeEntities(int index) {
        this.entities.remove(index);
    }

    public List<Organism> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "entities=" + entities.toString() +
                '}';
    }
}
