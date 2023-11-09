package pacman.classes.Bridge;

import javax.swing.*;
import java.awt.*;

public class RedColor implements IColor {
    private Image color;
    public RedColor() {
        this.color = new ImageIcon("./Working/images/red.gif").getImage();
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
