package Practice_2;

import java.util.ArrayList;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Окружность с центром в точке " + center + " и радиусом " + radius;
    }
}

class Tester {
    private ArrayList<Circle> circles;
    private int count;

    public Tester() {
        circles = new ArrayList<>();
        count = 0;
    }

    public void addCircle(Circle circle) {
        circles.add(circle);
        count++;
    }

    public void displayCircles() {
        if (circles.isEmpty()) {
            System.out.println("Магазин пуст.");
        } else {
            System.out.println("Список окружностей:");
            for (Circle circle : circles) {
                System.out.println(circle);
            }
        }
    }

    public int getCount() {
        return count;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Point center1 = new Point(0, 0);
        Circle circle1 = new Circle(center1, 5);

        Point center2 = new Point(2, 3);
        Circle circle2 = new Circle(center2, 4);

        Tester tester = new Tester();
        tester.addCircle(circle1);
        tester.addCircle(circle2);
        tester.displayCircles();
    }
}
