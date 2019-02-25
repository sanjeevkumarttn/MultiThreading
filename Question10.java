//Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.

package multithreading;

public class Question10 {

    int count;

     public synchronized void incrementCount() {
        count++;
    }

     public synchronized int getCount() {
        return count;
    }

    public void worker1() {
        for (int i = 1; i <= 10; i++) {
            incrementCount();
            System.out.println("Worker1: "+getCount());
        }
    }

    public void worker2() {

        for (int i = 1; i <= 10; i++) {
            incrementCount();
            System.out.println("Worker2: "+getCount());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Question10 question10 = new Question10();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                question10.worker1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                question10.worker2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //System.out.println(question10.count);
    }
}
