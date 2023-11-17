package pacman.classes.TemplateMethod;

import java.awt.*;

public abstract class AbstractItem {
    private Image image;

    public abstract void setPoints(int points);

    public abstract int getPoints();

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
