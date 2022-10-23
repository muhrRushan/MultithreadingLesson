import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Singer extends Thread{

    private final Logger logger = LogManager.getLogger();

    public Singer(String threadName) {
        super.setName(threadName);
        this.start();
    }

    @Override
    public void run() {
        logger.info("started");
        int count = 0;
        while (count < 3) {
            count++;
            System.out.print(super.getName() + ": ");
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.print("La La La La La    ");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
            synchronized (Monitoring.MICRO2) {
                Monitoring.MICRO2.notify();
            }
            synchronized (Monitoring.MICRO1) {
                try {
                    Monitoring.MICRO1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (Monitoring.MICRO1) {
            Monitoring.MICRO1.notify();
        }
        logger.info("ended");
    }
}
