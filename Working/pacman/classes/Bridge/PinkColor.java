package pacman.classes.Bridge;
import javax.swing.*;
import java.awt.*;

public class PinkColor implements IColor {
    private Image color;

    public PinkColor() {
        this.color = new ImageIcon("./Working/images/pink.gif").getImage();
    }

    @Override
    public Image getColor() {
        return this.color;
    }

    @Override
    public void setColor(Image color) {
        this.color = color;
    }
}
