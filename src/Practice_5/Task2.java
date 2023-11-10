package Practice_5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class RectangleShape extends Shape {
    private int width;
    private int height;

    public RectangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class OvalShape extends Shape {
    private int width;
    private int height;

    public OvalShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}

public class Task2 extends JFrame {

    private final List<Shape> shapes = new ArrayList<>();

    public Task2() {
        setTitle("Random Shapes");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int x = rand.nextInt(getWidth());
            int y = rand.nextInt(getHeight());
            int width = rand.nextInt(100) + 50;
            int height = rand.nextInt(100) + 50;
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

            int shapeType = rand.nextInt(2);

            Shape shape;
            if (shapeType == 0) {
                shape = new RectangleShape(color, x, y, width, height);
            } else {
                shape = new OvalShape(color, x, y, width, height);
            }

            shapes.add(shape);
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Shape shape : shapes) {
                    shape.draw(g);
                }
            }
        };

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }
}
