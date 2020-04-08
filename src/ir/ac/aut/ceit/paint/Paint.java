package ir.ac.aut.ceit.paint;

import java.util.ArrayList;

/**
 * Paint class
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Paint {
    private ArrayList<Shape> shapes;

    public Paint() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void drawAll() {
        for(Shape shape : shapes) {
            if(shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println(circle);
            } else if(shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println(triangle);
            } else {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println(rectangle);
            }
        }
    }

    public void printAll() {
        for(Shape shape : shapes) {
            if(shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println(circle);
            } else if(shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println(triangle);
            } else {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println(rectangle);
            }
        }
    }

    public void describeEqualSides() {
        for(Shape shape : shapes) {
            if(shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                if(triangle.isEquilateral())
                    System.out.println(triangle);
            } else if(shape instanceof Rectangle){
                Rectangle rectangle = (Rectangle) shape;
                if(rectangle.isSquare())
                    System.out.println(rectangle);
            }
        }
    }
}
