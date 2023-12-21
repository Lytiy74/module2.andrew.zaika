package com.andrew.entities.organism.animal.predator;

import com.andrew.entities.organism.animal.Animal;
import com.andrew.service.ConfigLoader;
import lombok.extern.log4j.Log4j2;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.reflections.Reflections.log;

@Log4j2
public abstract class Predator extends Animal {
    @Override
    public void eat(){
        List<Animal> animals = getCell().getAnimals();
        Iterator<Animal> iterator = animals.iterator();
        Random random = new Random();
        while(iterator.hasNext()) {
         Animal animal =  iterator.next();
            if (animal != this && getRandomBooleanWithProbability(ConfigLoader.getDoubleProperty(this.getPropertiesKey() + "eat." + animal.getClass().getSimpleName().toLowerCase()))) {
                this.setSaturation(getSaturation() + animal.getWeight());
                log.info(this.getClass().getSimpleName() + " eat " + animal.getClass().getSimpleName());
                iterator.remove();
                getCell().removeEntity(animal);
            }
        }
    }
    private boolean getRandomBooleanWithProbability(double probability){
        if (probability < 0 || probability > 1) {
            throw new IllegalArgumentException("Probability must be between 0 and 1");
        }

        Random random = new Random();
        return random.nextDouble() < probability;
    }
}
