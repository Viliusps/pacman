package pacman.classes;

public class Pacman {
    private int x;
    private int y;
    private int dx;
    private int dy;

    private int speed;

    private boolean dying;
    private int lives;
    private int score;

    public Pacman() {
        this.speed = 6;
        this.dying = false;
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

    public int getScore(){
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score){
        this.score += score;
    }
}
