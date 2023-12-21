package com.andrew.entities.organism.animal.predator;

import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.animal.Animal;

import java.util.List;

public abstract class Predator extends Animal {
    @Override
    public void eat(){
        List<Organism> organisms = getCell().getEntities();
        for (Organism item : organisms) {
            item.getClass();
        }
    }
}
