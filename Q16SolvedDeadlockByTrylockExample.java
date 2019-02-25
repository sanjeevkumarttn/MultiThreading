package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q16SolvedDeadlockByTrylockExample {
    Lock lock1=new ReentrantLock(true);
    Lock lock2=new ReentrantLock(true);

    public void acquireLock(Lock lock1,Lock lock2){
        boolean acquirelock1=lock1.tryLock();
        boolean acquirelock2=lock2.tryLock();

        if(acquirelock1 && acquirelock2)
            return;
        if(acquirelock1){
            lock1.unlock();
        }if(acquirelock2){
            lock2.unlock();
        }
    }

    public void worker1(){
        acquireLock(lock1,lock2);
        System.out.println("lock1 on worker1");
        System.out.println("lock2 on worker1");
        lock2.unlock();
        lock1.unlock();
    }
    public void worker2(){
        acquireLock(lock2,lock1);
        System.out.println("lock2 on worker2");
        System.out.println("lock1 on worker2");
        try {
            lock1.unlock();
            lock2.unlock();
        }catch (Exception e){}

    }

    public static void main(String[] args) throws InterruptedException {
        Q16SolvedDeadlockByTrylockExample solvedDeadlockByTrylockExample=new Q16SolvedDeadlockByTrylockExample();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                solvedDeadlockByTrylockExample.worker1();
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                solvedDeadlockByTrylockExample.worker2();
            }
        });


        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
