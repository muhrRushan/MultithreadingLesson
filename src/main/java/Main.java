import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        logger.info("started");
        System.out.println("Show started");
        Singer singer1 = new Singer("Singer 1");
        Singer1 singer2 = new Singer1("Singer 2");
        Singer2 singer3 = new Singer2("Singer 3");

        while (singer3.isAlive()) {
        }
        System.out.println("Show ended. Go away");
        logger.info("ended");
    }
}
