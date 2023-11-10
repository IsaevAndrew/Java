package Practice_7;

interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
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
    public void moveUp() {
        y += ySpeed;
    }

    public void moveDown() {
        y -= ySpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }


    public boolean SpeedTest(MovablePoint point) {
        return xSpeed == point.getXSpeed() && ySpeed == point.getYSpeed();
    }
}

class MovableRectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    public boolean SpeedTest() {
        return topLeft.SpeedTest(bottomRight);
    }

    @Override
    public String toString() {
        return "MovableRectangle (topLeft=" + topLeft + ", bottomRight=" + bottomRight + ")";
    }
}


public class Task3 {
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(0, 0, 2, 2, 1, 1);
        System.out.println(rectangle);

        System.out.println("Двигаем вверх:");
        rectangle.moveUp();
        System.out.println(rectangle);

        System.out.println("Двигаем вправо:");
        rectangle.moveRight();
        System.out.println(rectangle);

        System.out.println("Двигаем вниз:");
        rectangle.moveDown();
        System.out.println(rectangle);

        System.out.println("Двигаем влево:");
        rectangle.moveLeft();
        System.out.println(rectangle);
        if (rectangle.SpeedTest()) {
            System.out.println("Точки прямоугольника имеют одинаковую скорость");
        } else {
            System.out.println("Точки прямоугольника имеют разную скорость");
        }
    }
}
