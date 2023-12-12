package com.andrew.entities.organism.animal;

import com.andrew.entities.organism.Eatable;
import com.andrew.entities.organism.Movable;
import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.Reproducible;

public abstract class Animal extends Organism implements Reproducible, Movable, Eatable {
    private int weight;
    private int saturation;
    private int maxSpeed;

    public Animal(int weight, int saturation, int maxSpeed) {
        this.weight = weight;
        this.saturation = saturation;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {

    }
    @Override
    public void eat() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", saturation=" + saturation +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
