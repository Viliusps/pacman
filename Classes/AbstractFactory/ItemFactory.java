package AbstractFactory;

public class ItemFactory implements GameElementFactory {
    @Override
    public int setInitialX() {
        return 0;
    }

    @Override
    public int setInitialY() {
        return 0;
    }

    @Override
    public String setInitialColor() {
        return null;
    }
}
