package ir.ac.aut.ceit.paint;

/**
 * Rectangle class
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Rectangle extends Polygon {

    public Rectangle(double a, double b, double c, double d) {
        super();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    public boolean isSquare() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2)) &&
                sides.get(0).equals(sides.get(3));
    }

    @Override
    public double calculatePerimeter() {
        double ret = 0.0d;
        for(double side : sides) {
            ret += side;
        }
        return ret;
    }

    @Override
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides + ", isSquare=" +
                (isSquare() ? "true" : "false") +
                '}';
    }
}

