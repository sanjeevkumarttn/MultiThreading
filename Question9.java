// Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().

package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Question9 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newFixedThreadPool(4);

        service1.submit(new CountDownClock1("A"));
        service1.submit(new CountDownClock1("B"));
        service1.submit(new CountDownClock1("C"));
        service1.submit(new CountDownClock1("D"));
       service1.awaitTermination(5, TimeUnit.SECONDS);
       System.out.println("");

        service2.submit(new CountDownClock2("A"));
        service2.submit(new CountDownClock2("B"));
        service2.submit(new CountDownClock2("C"));
        service2.submit(new CountDownClock2("D"));

        service1.shutdown();
        service2.shutdown();

    }
}


class CountDownClock1 implements Runnable {
    private String clockName;

    public CountDownClock1(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        //System.out.println("\nExexcuting newCachedThreadPool() ...\n");
        for (int i = 3; i >= 0; i--) {

            System.out.printf("Exexcuting newCachedThreadPool() : %s -> %s: %d\n", threadName, clockName, i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class CountDownClock2 implements Runnable {
    private String clockName;

    public CountDownClock2(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        //System.out.println("\nExexcuting newFixedThreadPool() ...\n");
        for (int i = 3; i >= 0; i--) {

            System.out.printf("Exexcuting newFixedThreadPool() : %s -> %s: %d\n", threadName, clockName, i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}