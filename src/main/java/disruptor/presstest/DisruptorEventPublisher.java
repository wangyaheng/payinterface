package disruptor.presstest;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorEventPublisher implements EventPublisher{
    private static final WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();

    private Disruptor<TestEvent> disruptor;
    private TestEventHandler handler;
    private RingBuffer<TestEvent> ringbuffer;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public DisruptorEventPublisher(int size,TestHandler testHandler){
        this.handler = new TestEventHandler(testHandler);
        disruptor = new Disruptor<TestEvent>(()-> new TestEvent(),size,executor, ProducerType.SINGLE,
                YIELDING_WAIT);




    }

    static class TestEventHandler implements EventHandler<TestEvent> {

        private TestHandler handler;

        public TestEventHandler(TestHandler handler) {
            this.handler = handler;
        }


        @Override
        public void onEvent(TestEvent testEvent, long l, boolean b) throws Exception {
            handler.handle();
        }
    }
    @Override
    public void publish(int data) throws InterruptedException {
        long seq = ringbuffer.next();
        try {
            TestEvent evt = ringbuffer.get(seq);
            evt.setI(22);
        } finally {
            ringbuffer.publish(seq);
        }
    }

    @Override
    public void start() {
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringbuffer = disruptor.getRingBuffer();

    }
}
