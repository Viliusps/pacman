package pacman.classes.Bridge;

import javax.swing.*;
import java.awt.*;
public class BlueColor implements IColor {
    private Image color;
    public BlueColor() {
        this.color = new ImageIcon("./Working/images/blue.gif").getImage();
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
