import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reception {

    private final List<Client> mClientList;
    private static final int maxClientInReception = 5;
    private int clientCounter = 0;

    public Reception() {
        mClientList = new ArrayList<>();
    }

    public synchronized boolean add(Client element) {

        try {
            if (clientCounter < maxClientInReception) {
                notifyAll();
                mClientList.add(element);
                String info = String.format("The client %s came to the reception: %s", mClientList.size(), element.getName(), Thread.currentThread().getName());
                System.out.println(info);
                clientCounter++;

            } else {
                System.out.println(mClientList.size() + " > There is no place for a client in the reception: " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Client get() {

        try {
            if (clientCounter > 0) {
                notifyAll();
                for (Client client : mClientList) {
                    clientCounter--;
//                    Thread.sleep(200);
                    System.out.println("All clients in the reception: " + mClientList.size() + ", The client was summoned: " + client.getName());
                    mClientList.remove(client);
                    return client;
                }
            }

            System.out.println("0 < There are no clients in reception");
            DateHolder.printDifference(new Date());
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}