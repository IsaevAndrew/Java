package Practice_6;

interface Movable {
    void MoveUp();

    void MoveDown();

    void MoveLeft();

    void MoveRight();
}

class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void MoveUp() {
        y++;
    }

    @Override
    public void MoveDown() {
        y--;
    }

    @Override
    public void MoveLeft() {
        x--;
    }

    @Override
    public void MoveRight() {
        x++;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}

class MovableCircle extends MovablePoint implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        super(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }
}

public class Task1 {
    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(10, 15, 0, 0);
        MovablePoint p2 = new MovablePoint(1, 2, 5, 10);

        MovableCircle c1 = new MovableCircle(10, 12, 0, 0, 10);

        System.out.println(p1);
        System.out.println(p2);
        p1.MoveLeft();
        p1.MoveUp();
        System.out.println(p1);

        System.out.println(c1.getRadius());
        c1.setRadius(1);
        c1.MoveDown();
        System.out.println(c1);

    }
}
