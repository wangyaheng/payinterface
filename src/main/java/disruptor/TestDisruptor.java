package disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 高性能的异步处理框架
 */
public class TestDisruptor {

    public static void main(String[] args) {
        String message = "hello distuptor!!!!";
        int ringBufferSize = 1024;//必须是2的N次方
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Disruptor<MessageEvent> disruptor = new Disruptor<MessageEvent>(new MessageEventFactory(),ringBufferSize, executorService, ProducerType.SINGLE,new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MessageEventHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageProducer messageProducer = new MessageProducer(ringBuffer);
        messageProducer.onData(message);

        disruptor.shutdown();
        executorService.shutdown();// disruptor 不会关闭线程池

    }
}
