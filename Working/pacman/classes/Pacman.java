package pacman.classes;

import java.awt.Image;

import javax.swing.ImageIcon;

import pacman.classes.Adapter.PowerUpAdapter;
import pacman.classes.Observer.GameEvent;
import pacman.classes.Observer.GameSubject;
import pacman.classes.State.DefaultState;
import pacman.classes.State.PacmanState;

public class Pacman {
    private PacmanState state;

    private int x;
    private int y;
    private int dx;
    private int dy;

    private Image up;
    private Image down;
    private Image left;
    private Image right;
    
    private int speed;

    private boolean dying;
    private int lives;
    private boolean invincible;

    private PowerUpAdapter powerUp;

    public Pacman() {
        this.state = new DefaultState(this);
        this.speed = 3;
        this.dying = false;
        this.powerUp = null;
        this.invincible = true;//reset after
        this.down = new ImageIcon("./Working/images/down.gif").getImage();
        this.up = new ImageIcon("./Working/images/up.gif").getImage();
    	this.left = new ImageIcon("./Working/images/left.gif").getImage();
    	this.right = new ImageIcon("./Working/images/right.gif").getImage();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDX() {
        return this.dx;
    }

    public int getDY() {
        return this.dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed() {
        state.setSpeed();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getDying(){
        return this.dying;
    }

    public void setDying(boolean dying){
        this.dying = dying;
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public void setPowerUp(PowerUpAdapter powerUp) {
        this.powerUp = powerUp;
    }

    public void applyPowerUp() {
        if (powerUp != null) {
            powerUp.apply(this);
            powerUp = null;
        }
    }

    public void setInvincible(){
        state.setInvincible();
    }

    public void setInvincible(boolean invincible){
        this.invincible = invincible;
        if(!invincible){
            this.down = new ImageIcon("./Working/images/down.gif").getImage();
            this.up = new ImageIcon("./Working/images/up.gif").getImage();
            this.left = new ImageIcon("./Working/images/left.gif").getImage();
            this.right = new ImageIcon("./Working/images/right.gif").getImage();
        }
        else{
            this.down = new ImageIcon("./Working/images/downGray.gif").getImage();
            this.up = new ImageIcon("./Working/images/upGray.gif").getImage();
            this.left = new ImageIcon("./Working/images/leftGray.gif").getImage();
            this.right = new ImageIcon("./Working/images/rightGray.gif").getImage();
        }
    }

    public Pacman deepClone(){
        Pacman pacman = new Pacman();
        pacman.setX(this.x);
        pacman.setY(this.y);
        pacman.setDX(this.dx);
        pacman.setDY(this.dy);
        pacman.setSpeed(this.speed);
        pacman.setDying(this.dying);
        pacman.setLives(this.lives);
        pacman.setInvincible(this.invincible);
        pacman.setPowerUp(this.powerUp);
        return pacman;
    }

    public boolean getInvincible(){
        return this.invincible;
    }

    public Image getUp(){
        return this.up;
    }
    public Image getDown(){
        return this.down;
    }
    public Image getRight(){
        return this.right;
    }
    public Image getLeft(){
        return this.left;
    }

    public void eatPellet(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.PELLET_EATEN));
    }

    public void eatPowerPellet(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.POWER_PELLET_EATEN));
    }

    public void eatFruit(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.FRUIT_EATEN));
    }

    public void eatDoublePointsFruit(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.DOUBLE_POINTS_FRUIT_EATEN));
    }

    public void eatGhostFrightenedFruit(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.GHOST_FRIGHTENED_FRUIT_EATEN));
    }

    public void eatGhost(GameSubject subject) {
        subject.notifyObservers(new GameEvent(GameEvent.EventType.GHOST_EATEN));
    }

    public void changeState(PacmanState state) {
        this.state = state;
    }
}
