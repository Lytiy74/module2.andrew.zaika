package com.andrew.entities.organism.animal.herbivore;

import com.andrew.entities.organism.Entity;
import com.andrew.service.ConfigLoader;
@Entity
public class Horse extends Herbivore{
    private static final String PROPERTIES_KEY = "entities.organism.animal.herbivore.horse.";
    public Horse() {
        super.setMaxQuantity(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxQuantity"));
        super.setMaxSpeed(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxSpeed"));
        super.setWeight(ConfigLoader.getIntProperty(PROPERTIES_KEY + "weight"));
        super.setSaturation(ConfigLoader.getIntProperty(PROPERTIES_KEY + "saturation"));
    }

    @Override
    protected String getPropertiesKey() {
        return PROPERTIES_KEY;
    }
}
