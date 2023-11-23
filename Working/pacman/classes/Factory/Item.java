package pacman.classes.Factory;

import java.awt.Graphics2D;

public interface Item
{
    public abstract int getPoints();
    public abstract void setPoints(int points);
    public abstract void draw(Graphics2D g2d);
}
