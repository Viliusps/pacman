package pacman.classes;

import java.awt.*;

public class Ghost {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int speed;
    private Image color;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Image getColor() {
        return this.color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(Image color) {
        this.color = color;
    }
}
