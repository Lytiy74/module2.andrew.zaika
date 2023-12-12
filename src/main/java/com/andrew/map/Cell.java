package com.andrew.map;

import com.andrew.entities.organism.Organism;

import java.util.List;

public class Cell {
    private List<Organism> entities;

    public Cell(List<Organism> entities) {
        this.entities = entities;
    }
    public void setEntities(List<Organism> entities) {
        this.entities = entities;
    }
    public void addEntities(Organism entities){
        this.entities.add(entities);
    }
    public void removeEntities(int index){
        this.entities.remove(index);
    }
    public List<Organism> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "entities=" + entities +
                '}';
    }
}
