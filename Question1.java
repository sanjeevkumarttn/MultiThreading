// Create and Run a Thread using Runnable Interface and Thread class.

package multithreading;

public class Question1 {

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
        new ThreadDemo().start();
    }
}

class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Running Thread using Runnable Interface...");
    }
}

class ThreadDemo extends Thread{

    @Override
    public void run(){
        System.out.println("Running Thread using Thread Class...");
    }

}
