package algorithm;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSnowFlake {
    public static void main(String[] args) throws InterruptedException {
        Snowflake snowflake = new Snowflake(0,0);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CountDownLatch timecountDownLatch = new CountDownLatch(10*10000);
        long startTime = System.currentTimeMillis();


        for (int i=0;i<10;i++){
            executorService.execute(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j=0;j<10000;j++){
                    System.out.println(snowflake.nextId());
                    timecountDownLatch.countDown();
                }

            });
            countDownLatch.countDown();

        }


        timecountDownLatch.await();
        System.out.println(System.currentTimeMillis()-startTime);
        executorService.shutdownNow();
    }

}
