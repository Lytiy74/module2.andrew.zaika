package com.andrew.entities.organism.animal.herbivore;

import com.andrew.entities.organism.animal.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(int weight, int saturation, int maxSpeed) {
        super(weight, saturation, maxSpeed);
    }
}
