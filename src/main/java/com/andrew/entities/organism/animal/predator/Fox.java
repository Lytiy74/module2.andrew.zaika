package com.andrew.entities.organism.animal.predator;

import com.andrew.entities.organism.Entity;
import com.andrew.service.ConfigLoader;
@Entity
public class Fox extends Predator{
    private static final String PROPERTIES_KEY = "entities.organism.animal.predator.fox.";

    public Fox() {
        super.setMaxQuantity(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxQuantity"));
        super.setMaxSpeed(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxSpeed"));
        super.setWeight(ConfigLoader.getIntProperty(PROPERTIES_KEY + "weight"));
        super.setSaturation(ConfigLoader.getIntProperty(PROPERTIES_KEY + "saturation"));
    }

    @Override
    public String getPropertiesKey() {
        return this.PROPERTIES_KEY;
    }

    @Override
    public String toString() {
        return "Fox";
    }
}
