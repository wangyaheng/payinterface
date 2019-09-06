package thread.future;

import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2, TimeUnit.MINUTES, new LinkedBlockingQueue<>(2));
        FutureTask<String> futureTask = new FutureTask(new MyCallable());
        //new Thread(futureTask).start();
        threadPoolExecutor.execute(futureTask);

        System.out.println("thread start");
        System.out.println(futureTask.isDone());
        String o = futureTask.get();
        System.out.println(futureTask.isDone());
        System.out.println(o);
    }
}
