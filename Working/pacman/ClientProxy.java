package pacman;

public class ClientProxy implements IClient{
    private Client client;

    @Override
    public void play(boolean epilepsy) {
        if(client == null) {
            client = new Client(epilepsy);
        }

        client.play(epilepsy);
    }
}
