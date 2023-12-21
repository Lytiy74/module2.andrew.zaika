package com.andrew.entities.organism.animal;

import com.andrew.entities.organism.Eatable;
import com.andrew.entities.organism.Movable;
import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.Reproducible;
import com.andrew.map.Coordinates;
import com.andrew.map.GameField;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

import static org.reflections.Reflections.log;
@Log4j2
public abstract class Animal extends Organism implements Reproducible, Movable, Eatable {
    private int weight;
    private int saturation;
    private int maxSpeed;
    public void play(){
        move();
        eat();
        reproduce();
    }
    public void move() {
        Random random = new Random();
        int deltaX = random.nextInt(3) - 1;
        int deltaY = random.nextInt(3) - 1;
        Coordinates newCoordinates = new Coordinates();
        newCoordinates.setX(getCell().getCoordinates().getX() + deltaX);
        newCoordinates.setY(getCell().getCoordinates().getY() + deltaY);
        if (canMove(newCoordinates)) {
            GameField.getInstance().updateCell(this.getCell().getCoordinates(), newCoordinates, this);
            log.info(  this.getClass().getSimpleName() + " was in (" +getCell().getCoordinates().getX() + ", " + getCell().getCoordinates().getY() + ")");
            log.info(this.getClass().getSimpleName() + " moved to (" + newCoordinates.getX() + ", " + newCoordinates.getY() + ")");
            GameField.getInstance().updateCell(getCell().getCoordinates(), newCoordinates, this);
        } else {
            log.info(this.getClass().getSimpleName() + " cannot move to (" + newCoordinates.getX() + ", " + newCoordinates.getY() + ")");
        }
    }
    private boolean canMove(Coordinates coordinates) {
            int x = coordinates.getX();
            int y = coordinates.getY();
            int width = GameField.getInstance().getWidth();
            int height = GameField.getInstance().getHeight();

            return x >= 0 && x < width && y >= 0 && y < height;
    }
    public void eat() {
        log.info("Animal eat!");
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
