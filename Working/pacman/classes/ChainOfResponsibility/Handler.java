package pacman.classes.ChainOfResponsibility;

public interface Handler {
    public Handler setNext(Handler h);
    public void handle(Request request);
}
