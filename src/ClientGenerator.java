import java.util.Random;

public class ClientGenerator implements Runnable {

    private final Reception mReception;
    private final int clientCount;

//    private final Random mRandom = new Random(3000);

    public ClientGenerator(Reception reception, int clientCount) {
        this.mReception = reception;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < clientCount) {
            Thread.currentThread().setName("Client generator");
            count++;
            mReception.add(new Client(Integer.toString(count)));
//            try {
//                Thread.sleep(mRandom.nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}