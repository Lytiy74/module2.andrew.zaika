package com.andrew.entities.organism.animal.herbivore;

import com.andrew.entities.organism.animal.Animal;
import com.andrew.entities.organism.plants.Plants;

import java.util.List;

public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        List<Plants> plantsList = getCell().getPlants();
        if (!plantsList.isEmpty()){
            plantsList.remove(0);
            this.setSaturation(getSaturation() + 1);
        }
    }
}
