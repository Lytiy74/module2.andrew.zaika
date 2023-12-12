package com.andrew.entities.organism.animal.predator;

import com.andrew.entities.organism.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(int weight, int saturation, int maxSpeed) {
        super(weight, saturation, maxSpeed);
    }
}
