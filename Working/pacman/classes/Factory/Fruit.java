package pacman.classes.Factory;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fruit implements Item
{
	private int points;
    private Image image;

    public Fruit(){
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

}
