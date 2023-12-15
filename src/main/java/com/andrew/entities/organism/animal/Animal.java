package com.andrew.entities.organism.animal;

import com.andrew.entities.organism.Eatable;
import com.andrew.entities.organism.Movable;
import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.Reproducible;

public abstract class Animal extends Organism implements Reproducible, Movable, Eatable {
    private int weight;
    private int saturation;
    private int maxSpeed;

    public void move() {

    }
    public void eat() {

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }


    public int getSaturation() {
        return saturation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    protected abstract String getPropertiesKey();

    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", saturation=" + saturation +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
