package pacman.classes.Bridge;

import javax.swing.*;
import java.awt.*;

public class OrangeColor implements IColor {
    private Image color;
    public OrangeColor() {
        this.color = new ImageIcon("./Working/images/orange.gif").getImage();
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
