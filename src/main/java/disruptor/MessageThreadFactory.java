package disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * 消息线程工厂类
 */
public class MessageThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"testDisruptor");
    }
}
