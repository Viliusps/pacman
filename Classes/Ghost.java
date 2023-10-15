public class Ghost {
    private int x;
    private int y;
    private String direction;

    private Ghost() {
    }

    private int getX() {
        return this.x;
    }

    private int getY() {
        return this.y;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    private String getDirection() {
        return this.direction;
    }

    private void setDirection(String direction) {
        this.direction = direction;
    }
}