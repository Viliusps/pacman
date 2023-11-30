package pacman.classes.ChainOfResponsibility;

public abstract class BaseHandler implements Handler{

    private Handler next;

    @Override
    public Handler setNext(Handler h) {
        this.next = h;
        return this;
    }

    @Override
    public abstract void handle(Request request);

    @Override
    public Handler getNext() {
        return this.next;
    }
    
}
