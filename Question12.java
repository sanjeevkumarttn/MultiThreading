// Use Atomic Classes instead of Synchronize method and blocks.

package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Question12 {

    AtomicInteger count = new AtomicInteger();

//    public void incrementCount() {
//        synchronized (this) {
//            count.incrementAndGet();
//        }
//    }

    public void worker1() {
        for (int i = 1; i <= 10; i++) {
            count.incrementAndGet();
            System.out.println("Worker1: " + count);
        }
    }

    public void worker2() {
        for (int i = 1; i <= 10; i++) {
            count.incrementAndGet();
            System.out.println("Worker2: " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Question12 question12 = new Question12();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                question12.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                question12.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //System.out.println(question12.count);
    }

}
