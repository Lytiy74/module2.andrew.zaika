package com.andrew.map;

import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.animal.Animal;
import com.andrew.entities.organism.plants.Plants;
import com.andrew.service.ConfigLoader;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

import static org.reflections.Reflections.log;

@Log4j2
public class Cell {
    private Coordinates coordinates = new Coordinates();
    private static final String PROPERTIES_KEY = "map.cell.";
    private List<List<? extends Organism>> entities = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Plants> plants = new ArrayList<>();
    private int maxEntetiesQuantity;

    public void setMaxEntetiesQuantity(int maxEntetiesQuantity) {
        this.maxEntetiesQuantity = maxEntetiesQuantity;
    }

    public int getMaxEntetiesQuantity() {
        return maxEntetiesQuantity;
    }


    public Cell(int row, int column) {
        coordinates.setX(column);
        this.coordinates.setY(row);
        this.maxEntetiesQuantity = ConfigLoader.getIntProperty(PROPERTIES_KEY + "max-entities-quantity");
        entities.add(animals);
        entities.add(plants);
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plants> getPlants() {
        return plants;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setPlants(List<Plants> plants) {
        this.plants = plants;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void addEntities(Organism entities) {
        if (entities instanceof Animal){
            addAnimal((Animal)entities);
        }
        else if(entities instanceof Plants){
            addPlant((Plants) entities);
        }
        else {
            log.warn("cant add to cell" + entities.getClass().getTypeName());
        }
    }
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
    public void addPlant(Plants plants) {
        this.plants.add(plants);
    }

    public void removeEntity(Organism organism) {
        if (organism instanceof Animal){
            animals.remove(organism);
        }
        else if(organism instanceof Plants){
            plants.remove(organism);
        }
        else {
            log.warn("cant remove from cell" + organism.getClass().getTypeName());
        }
    }

    public List<List<? extends Organism>> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Cell[" + coordinates.getY() + "][" + coordinates.getX() + "] {" +
                "entities=" + entities.toString() +
                '}';
    }
}
