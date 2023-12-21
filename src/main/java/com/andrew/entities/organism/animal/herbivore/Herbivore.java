package com.andrew.entities.organism.animal.herbivore;

import com.andrew.entities.organism.animal.Animal;
import com.andrew.entities.organism.plants.Plants;
import lombok.extern.log4j.Log4j2;

import java.util.Iterator;
import java.util.List;

import static org.reflections.Reflections.log;
@Log4j2
public abstract class Herbivore extends Animal {
    @Override
    public void eat() {
        List<Plants> plants = getCell().getPlants();
        Iterator<Plants> iterator = plants.iterator();
        while(iterator.hasNext()) {
            Plants plant =  iterator.next();
                this.setSaturation(getSaturation() + plant.getWeight());
                log.info(this.getClass().getSimpleName() + " eat " + plant.getClass().getSimpleName());
                iterator.remove();
                getCell().removeEntity(plant);

        }
    }
}
