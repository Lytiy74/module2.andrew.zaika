package com.andrew.map;

import com.andrew.entities.organism.Organism;

import java.util.List;

public class Cell {
    private List<Organism> entities;

    public void setEntities(List<Organism> entities) {
        this.entities = entities;
    }

    public List<Organism> getEntities() {
        return entities;
    }

    public Cell(List<Organism> entities) {
        this.entities = entities;
    }
}
