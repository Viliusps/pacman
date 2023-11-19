package pacman.classes;

import pacman.classes.Bridge.IColor;
import pacman.classes.Prototype.Prototype;
import pacman.classes.Strategy.MoveAlgorithm;
import pacman.classes.TemplateMethod.AbstractAlgorithm;

import java.awt.*;
import java.util.List;

public class Ghost implements Prototype {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int speed;
    private Image color;
    private Boolean frightened;

    private MoveAlgorithm strategy;

    private AbstractAlgorithm algorithm;

    private IColor imageColor;

    public Ghost(IColor color) {
        this.imageColor = color;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Image getColor() {
        return this.imageColor.getColor();
    }

    public Boolean getFrightened() {
        return this.frightened;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor() {
        this.color = imageColor.getColor();
    }

    public void setFrightened(Boolean frightened) {
        this.frightened = frightened;
    }

    public void setStrategy(MoveAlgorithm strategy) { this.strategy = strategy;}
    public void setAlgorithm(AbstractAlgorithm algorithm) { this.algorithm = algorithm;}

    public MoveAlgorithm getStrategy() { return this.strategy; }
    public AbstractAlgorithm getAlgorithm() { return this.algorithm; }

    public IColor getImageColor() {
        return this.imageColor;
    }
    public void setImageColor(IColor imageColor) {
        this.imageColor = imageColor;
    }

    public void move(Pacman pac, short[] screenData, int blockSize, int nBlocks, List<Ghost> ghosts) {
        if (this.x % blockSize == 0 && this.y % blockSize == 0) {
            int pos = this.x / blockSize + nBlocks * (this.y / blockSize);
            this.algorithm.executeAlgorithm(this, pac, screenData, pos, ghosts);
            //this.strategy.execute(this, pac, screenData, pos, ghosts);
        }
        this.x = (this.x + this.dx * this.speed);
        this.y = (this.y + this.dy * this.speed);
    }

    @Override
    public Ghost deepClone() {
        Ghost ghost = new Ghost(this.imageColor);
        ghost.setX(this.x);
        ghost.setY(this.y);
        ghost.setDx(this.dx);
        ghost.setDy(this.dy);
        ghost.setSpeed(this.speed);
        ghost.setColor();
        ghost.setFrightened(this.frightened);
        ghost.setStrategy(this.strategy);
        return ghost;
    }

    @Override
    public Ghost clone() {
        try {
            return (Ghost) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
