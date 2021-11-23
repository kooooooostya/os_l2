import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Reception reception = new Reception();

        DateHolder.startDate = new Date();

        System.out.println(DateHolder.startDate);

        ClientGenerator clientGenerator = new ClientGenerator(reception, 10);

        Workplace workplace = new Workplace(reception);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(clientGenerator);
        service.execute(workplace);

        service.shutdown();
    }
}
