package ir.ac.aut.ceit.paint;

/**
 * Triangle class
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Triangle extends Polygon {

    public Triangle(double a, double b, double c) {
        super();
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2));
    }

    @Override
    public double calculatePerimeter() {
        double ret = 0.0d;
        for(double side : sides) {
            ret += side;
        }
        return ret;
    }

    /**
     * calculate area by heron formula
     * @return area of triangle
     */
    @Override
    public double calculateArea() {
        double p = calculatePerimeter();
        return Math.sqrt((p / 2 ) * (p / 2 - sides.get(0)) * (p / 2 - sides.get(1)) * (p / 2 - sides.get(2)));
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides + ", isEquilateral=" +
                (isEquilateral() ? "false" : "true") +
                '}';
    }
}
