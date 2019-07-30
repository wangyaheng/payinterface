package disruptor.presstest;

import java.util.concurrent.CountDownLatch;

/**
 * 计算固定次数，达到法制返回false
 */
public class CountTracerFixedTime implements CountTracer{
    private int count=0;
    private long startTime;
    private long endTime;
    private volatile boolean isEnd;

    public int throld;

    private CountDownLatch c = new CountDownLatch(1);
    @Override
    public void start() {
        startTime=System.currentTimeMillis();
        isEnd = false;
    }

    @Override
    public boolean count() {
        if(isEnd) return isEnd;

        count++;
        isEnd =count>=throld;
        if(isEnd){
            endTime=System.currentTimeMillis();
            System.out.println("end cost time:"+(endTime-startTime)+"--"+count);
            c.countDown();
        }
        return true;
    }

    @Override
    public void end() {
        isEnd=true;
    }

    @Override
    public void waitForReach() throws InterruptedException {
        c.await();
    }
}
