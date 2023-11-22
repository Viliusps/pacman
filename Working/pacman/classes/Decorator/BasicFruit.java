package pacman.classes.Decorator;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import pacman.classes.Factory.Item;

public class BasicFruit implements Fruit, Item
{
	private int points;
	private Image image;
	
    public BasicFruit(){
        this.points = 20;
        this.image = new ImageIcon("./Working/images/fruit.gif").getImage();
    }

    @Override
    public int getPoints(){
        return this.points;
    }

    @Override
    public void setPoints(int points){
        this.points = points;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2d) {
    }
}
