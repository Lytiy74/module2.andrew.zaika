package com.andrew.entities.organism.animal;

import com.andrew.entities.organism.Eatable;
import com.andrew.entities.organism.Movable;
import com.andrew.entities.organism.Organism;
import com.andrew.entities.organism.Reproducible;
import com.andrew.map.Coordinates;
import com.andrew.map.GameField;
import com.andrew.service.Logger;

import java.util.Random;

public abstract class Animal extends Organism implements Reproducible, Movable, Eatable {
    private int weight;
    private int saturation;
    private int maxSpeed;

    public void move() {
        Random random = new Random();
        int deltaX = random.nextInt(3) - 1;  // displacement from -1 to 1 on the X axis
        int deltaY = random.nextInt(3) - 1;  // displacement from -1 to 1 on the Y axis
        Coordinates newCoordinates = new Coordinates();
        newCoordinates.setX(getCell().getCoordinates().getX() + deltaX);
        newCoordinates.setY(getCell().getCoordinates().getY() + deltaY);


        if (canMove(newCoordinates)) {
            GameField.getInstance().updateCell(this.getCell().getCoordinates(), newCoordinates, this);
            Logger.log("Animal was in (" +getCell().getCoordinates().getX() + ", " + getCell().getCoordinates().getY() + ")");
            Logger.log("Animal moved to (" + newCoordinates.getX() + ", " + newCoordinates.getY() + ")");
            GameField.getInstance().updateCell(getCell().getCoordinates(), newCoordinates, this);
        } else {
            Logger.log("Animal cannot move to (" + newCoordinates.getX() + ", " + newCoordinates.getY() + ")");
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
        System.out.println("Animal eat!");
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
