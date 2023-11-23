package pacman.classes.Factory;

import java.awt.Color;
import java.awt.Graphics2D;

public class Pellet implements Item
{
    private int points;
    private Color color;

    public Pellet(){
        this.points = 1;
    }

    public Pellet(Color color) {
        this.color = color;
        this.points = -1;
    }

    @Override
    public int getPoints(){
        return this.points;
    }

    @Override
    public void setPoints(int points){
        this.points = points;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    } 
}
