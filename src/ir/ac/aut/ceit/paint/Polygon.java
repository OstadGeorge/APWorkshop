package ir.ac.aut.ceit.paint;

import java.util.ArrayList;

/**
 * Polygon class
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public abstract class Polygon implements Shape{
    protected ArrayList<Double> sides;

    public Polygon() {
        this.sides = new ArrayList<>();
    }

    public ArrayList<Double> getSides() {
        return sides;
    }
}
