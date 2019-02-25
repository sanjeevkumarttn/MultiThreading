// Use isShutDown() and isTerminate() with ExecutorService.


package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question5 {

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
            executorService.shutdownNow();
        }

        System.out.println("Is Shutdown: " + executorService.isShutdown());
        System.out.println("Is Terminated: " + executorService.isTerminated());

    }
}
