package com.andrew.entities.organism;

import com.andrew.map.Cell;

public class Organism implements Reproducible {
    private Cell cell; //link to cell where we are
    private int maxQuantity;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
    public void reproduce() {
        
    }
}
