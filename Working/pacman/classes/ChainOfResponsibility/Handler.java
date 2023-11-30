package pacman.classes.ChainOfResponsibility;

public interface Handler {
    public Handler setNext(Handler h);
    public Handler getNext();
    public void handle(Request request);
}
