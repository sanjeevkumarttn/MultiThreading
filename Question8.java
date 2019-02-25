// Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()

package multithreading;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Question8 {
    public static void main(String[] args) {

        ScheduledExecutorService timer1 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService timer2 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService timer3 = Executors.newSingleThreadScheduledExecutor();

        Date now = new Date();
        System.out.println("First TimeStamp : " + new SimpleDateFormat("MM-dd-yyyy / hh:mm:ss").format(now) + "\n");

        Runnable timeStamp1 = new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                System.out.println("TimeStamp1 : " + new SimpleDateFormat("MM-dd-yyyy / hh:mm:ss").format(now));
            }
        };

        Runnable timeStamp2 = new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                System.out.println("TimeStamp2 : " + new SimpleDateFormat("MM-dd-yyyy / hh:mm:ss").format(now)+ "\n");
            }
        };

        Runnable timeStamp3 = new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                System.out.println("TimeStamp3 : " + new SimpleDateFormat("MM-dd-yyyy / hh:mm:ss").format(now)+ "\n");
            }
        };

        timer1.schedule(timeStamp1,5, TimeUnit.SECONDS);
        timer2.scheduleAtFixedRate(timeStamp2, 2, 10, TimeUnit.SECONDS);
        timer3.scheduleWithFixedDelay(timeStamp3, 2, 15, TimeUnit.SECONDS);

    }
}