public class Ghost
{
    private static int x;
    private static int y;
    private static String direction;
    private final static Ghost instance = new Ghost();

    private Ghost()
    {
        System.out.println("Singleton initialized");
    }

    private int getX()
    {
        return this.x;
    }

    private int getY()
    {
        return this.y;
    }

    private void setX(int x)
    {
        this.x = x;
    }

    private void setY(int y)
    {
        this.y = y;
    }

    private String getDirection()
    {
        return this.direction;
    }

    private void setDirection(String direction)
    {
        this.direction = direction;
    }

    public static Ghost getInstance()
    {

        System.out.println("Returning instance");
        return instance;
    }

}