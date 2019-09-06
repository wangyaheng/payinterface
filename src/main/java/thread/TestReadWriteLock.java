package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        new Thread(()->{

            readWriteLock.readLock().lock();
            System.out.println("get read lock");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("release read lock");
            readWriteLock.readLock().unlock();
        }).start();

        TimeUnit.SECONDS.sleep(1);


        new Thread(()->{

            readWriteLock.writeLock().lock();
            System.out.println("get write lock");

            System.out.println("release write lock");
            readWriteLock.writeLock().unlock();
        }).start();
    }
}
