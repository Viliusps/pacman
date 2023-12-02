package pacman;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class MenuItem extends JFrame implements ActionListener, MenuComponent {
    public abstract void setVisibility(boolean visible);
}
