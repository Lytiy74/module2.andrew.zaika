package com.andrew.entities.organism.plants;

import com.andrew.entities.organism.Entity;
import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.Reproducible;
import com.andrew.service.ConfigLoader;

@Entity
public class Plants extends Organism implements Reproducible {
    private static final String PROPERTIES_KEY = "entities.organism.plants.plants.";
    public Plants(){
        setMaxQuantity(ConfigLoader.getIntProperty(PROPERTIES_KEY + "maxQuantity"));
        setWeight(ConfigLoader.getIntProperty(PROPERTIES_KEY + "weight"));
    }

    @Override
    public String toString() {
        return "Plants";
    }
}
