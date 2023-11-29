package pacman.classes.Facade;

import pacman.Model;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facade extends JPanel implements ActionListener {
    private final Model model;

    public Facade(int pacmanLives, boolean epilepsy) {
        model = new Model(new TAdapter());
        model.setPacmanLives(pacmanLives);
        model.setScoringSystem(model.getScoringSystem());
        model.setEpilepsy(epilepsy);
    }

    public JPanel getModel() {
        return this.model;
    }

    public void startGame() {
        model.initializeGame();
    }

    public void moveLeft() {
        model.handleInput(KeyEvent.VK_LEFT);
    }

    public void moveRight() {
        model.handleInput(KeyEvent.VK_RIGHT);
    }

    public void moveUp() {
        model.handleInput(KeyEvent.VK_UP);
    }

    public void moveDown() {
        model.handleInput(KeyEvent.VK_DOWN);
    }

    public void updateGame() {
        model.repaint();
    }

    public void handleInput(int key) {
        model.handleInput(key);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            model.handleInput(key);
        }
    }


}
