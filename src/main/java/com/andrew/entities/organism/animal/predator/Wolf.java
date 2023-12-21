package com.andrew.entities.organism.animal.predator;

import com.andrew.entities.organism.Entity;
import com.andrew.service.ConfigLoader;
@Entity
public class Wolf extends Predator {
    private static final String PROPERTIES_KEY = "entities.organism.animal.predator.wolf.";

    public Wolf() {
        setMaxQuantity(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxQuantity"));
        setMaxSpeed(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxSpeed"));
        setWeight(ConfigLoader.getIntProperty(PROPERTIES_KEY + "weight"));
        setSaturation(ConfigLoader.getIntProperty(PROPERTIES_KEY + "saturation"));
    }

    @Override
    public String getPropertiesKey() {
        return this.PROPERTIES_KEY;
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
