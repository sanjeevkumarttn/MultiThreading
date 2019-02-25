// Try shutdown() and shutdownNow() and observe the difference.



/* Run the program by commenting  'executorService.shutdown(); and executorService.shutdownNow();' alternatively
*  in the finally block(line: 50 and line:51).
*
* When we call 'executorService.shutdown();' then ExecutorService execute all three tasks because all these task are submitted
* and stored in the blocking Queue but in case of 'executorService.shutdownNow();' it is not neccessary all tasks will
* execute, it may or may not be.
* */

package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1");
                }
            });

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2");
                }
            });

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        //                 e.printStackTrace();
                    }
                    System.out.println("Thread 3");
                }
            });

        } finally {
            executorService.shutdown();
           // executorService.shutdownNow();
        }

    }
}
