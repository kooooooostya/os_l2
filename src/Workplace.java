public class Workplace implements Runnable {
    private final Reception mReception;

    public Workplace(Reception reception) {
        this.mReception = reception;
    }

    @Override
    public void run() {

        while (true) {
//            try {
                Thread.currentThread().setName("Workplace");

                Client client = mReception.get();
                if (client != null)
//                    Thread.sleep(500);
                    System.out.println("Client's hair cut. " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}