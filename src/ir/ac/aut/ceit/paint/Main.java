package ir.ac.aut.ceit.paint;

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(12);
        Circle circle2 = new Circle(2);

        Rectangle rectangle1 = new Rectangle(1, 1, 1, 1);
        Rectangle rectangle2 = new Rectangle(1, 5, 1, 5);
        Rectangle rectangle3 = new Rectangle(2, 8, 2, 8);
        Rectangle rectangle4 = new Rectangle(5, 5, 5, 5);

        Triangle triangle1 = new Triangle(1, 3, 3);
        Triangle triangle2 = new Triangle(3, 3, 3);

        Paint paint = new Paint();

        paint.addShape(circle1);
        paint.addShape(circle2);
        paint.addShape(rectangle1);
        paint.addShape(rectangle2);
        paint.addShape(rectangle3);
        paint.addShape(rectangle4);
        paint.addShape(triangle1);
        paint.addShape(triangle2);

        System.out.println("---> drawAll METHOD <---");
        paint.drawAll();
        System.out.println("---> describeEqualSides METHOD <---");
        paint.describeEqualSides();
    }
}
