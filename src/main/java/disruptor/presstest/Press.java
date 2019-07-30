package disruptor.presstest;

import com.lmax.disruptor.dsl.Disruptor;

public class Press {
    public static void main(String[] args) throws InterruptedException {
        CountTracerFixedTime countTracerFixedTime = new CountTracerFixedTime();
        countTracerFixedTime.throld=1000000;
        TestHandler msgHandler = new TestHandler(countTracerFixedTime);

      /*BlockingEventPublisher blockingEventPublisher = new BlockingEventPublisher(1000000,msgHandler);
        blockingEventPublisher.start();
        for (int i=0;i<10000001;i++){
            blockingEventPublisher.publish(1);
        }
*/

        DisruptorEventPublisher disruptorEventPublisher = new DisruptorEventPublisher(1024,msgHandler);
        disruptorEventPublisher.start();
        for (int i=0;i<1000001;i++){
            disruptorEventPublisher.publish(1);
        }

    }
}
