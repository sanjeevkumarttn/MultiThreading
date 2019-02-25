package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q16DeadlockConditionExample {
    Lock lock1=new ReentrantLock(true);
    Lock lock2=new ReentrantLock(true);
    public void worker1(){
        lock1.lock();
        System.out.println("lock1 on worker1");
        lock2.lock();
        System.out.println("lock2 on worker1");
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("lock2 on worker2");
        lock1.lock();
        System.out.println("lock1 on worker2");
        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Q16DeadlockConditionExample solvingDeadlockConditionBytryLockExample=new Q16DeadlockConditionExample();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                solvingDeadlockConditionBytryLockExample.worker1();
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                solvingDeadlockConditionBytryLockExample.worker2();
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
