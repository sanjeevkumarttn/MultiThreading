// Submit List of tasks to ExecutorService and wait for the completion of all the tasks.

package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Question7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Future> allFuture = new ArrayList<>();
        for(int i=0; i<10; i++){
            Future<Integer> future = service.submit(new Task());
            allFuture.add(future);
            System.out.println(future.get());
        }

        for(int i=0; i<10; i++){
            Future<Integer> future = allFuture.get(i);

            try {
                Integer result = future.get();
                System.out.println("Result of future #"+i+" : "+result);
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                service.shutdown();
            }
        }

    }

}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(20);
    }
}