package Practice_4;

abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        color = "red";
        filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends Shape {
    protected double radius;

    public Circle() {
        radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle, radius = " + radius;
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        width = 0;
        length = 0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle, width = " + width + ", length = " + length;
    }
}

class Square extends Rectangle {

    public Square() {
        super(0, 0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}


public class Task8 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(15);
        Circle c3 = new Circle("red", true, 10);

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10, 50);
        Rectangle r3 = new Rectangle("blue", false, 20, 40);

        Square s1 = new Square();
        Square s2 = new Square(16);
        Square s3 = new Square("black", true, 20);

        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(c3.getPerimeter());
        System.out.println(c3.getRadius());
        System.out.println();

        r1.setLength(10);
        r1.setWidth(15);
        System.out.println(r1.getArea());

        System.out.println(r2.toString());
        System.out.println(r3.getPerimeter());
        System.out.println();

        s1.setSide(16);
        s1.setColor("white");

        System.out.println(s1.getColor());
        System.out.println(s1);
        System.out.println(s2.getArea());
        System.out.println(s3.getPerimeter());
    }
}
