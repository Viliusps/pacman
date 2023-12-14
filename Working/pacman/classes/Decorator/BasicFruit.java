package pacman.classes.Decorator;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import pacman.classes.Factory.Item;
import pacman.classes.Mediator.GhostMediator;
import pacman.classes.Mediator.PowerUpListener;

public class BasicFruit implements Fruit, Item, PowerUpListener
{
	private int points;
	private Image image;
    private boolean activated;
    private GhostMediator mediator;
	
    public BasicFruit(GhostMediator mediator){
        this.points = 20;
        this.image = new ImageIcon("./Working/images/fruit.gif").getImage();
        this.activated = true;
        this.mediator = mediator;
        mediator.registerElement(this);
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

    @Override
    public void onPowerUpActivated() {
        this.activated = true;
    }

    @Override
    public void onPowerUpDeactivated() {
        this.activated = false;
    }

    public boolean getActivated() {
        return this.activated;
    }
}
