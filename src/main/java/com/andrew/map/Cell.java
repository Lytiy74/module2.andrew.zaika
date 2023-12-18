    package com.andrew.map;

    import com.andrew.entities.organism.Organism;
    import com.andrew.service.ConfigLoader;

    import java.util.ArrayList;
    import java.util.List;

    public class Cell {
        private Coordinates coordinates = new Coordinates();
        private static final String PROPERTIES_KEY = "map.cell.";
        private List<Organism> entities = new ArrayList<>();
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
        }

        public Cell(List<Organism> entities) {
            this.entities = entities;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public void setEntities(List<Organism> entities) {
            this.entities = entities;
        }

        public void addEntities(Organism entities) {
            this.entities.add(entities);
        }

        public void removeEntity(Organism organism) {
            this.entities.remove(organism);
        }

        public List<Organism> getEntities() {
            return entities;
        }
        @Override
        public String toString() {
            return "Cell[" + coordinates.getY() +"][" + coordinates.getX() + "] {" +
                    "entities=" + entities +
                    '}';
        }
    }
