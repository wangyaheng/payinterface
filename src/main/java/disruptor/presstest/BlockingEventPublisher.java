package disruptor.presstest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingEventPublisher implements EventPublisher{

    private  BlockingQueue<TestEvent> b;
    private MsgHandler handler;

    public BlockingEventPublisher(int maxSize,MsgHandler handler){
        this.b = new ArrayBlockingQueue<TestEvent>(maxSize);
        this.handler = handler;
    }
    @Override
    public void publish(int data) throws InterruptedException {
        TestEvent t = new TestEvent();
        t.setI(2);
        b.put(t);
    }

    @Override
    public void start() {
        Thread thrd = new Thread(new Runnable() {
            @Override
            public void run() {
               while(true){
                   try {
                       TestEvent take = b.take();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   boolean handle = handler.handle();
                   if(!handle){
                       return;
                   }


               }
            }
        });
        thrd.start();
    }
}
