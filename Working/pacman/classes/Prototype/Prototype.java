package pacman.classes.Prototype;

public interface Prototype extends Cloneable {
    public Prototype deepClone();

    public Prototype clone();
}
