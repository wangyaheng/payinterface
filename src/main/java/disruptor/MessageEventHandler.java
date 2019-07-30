package disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * 消息处理类
 */
public class MessageEventHandler implements EventHandler<MessageEvent>{
    @Override
    public void onEvent(MessageEvent o, long l, boolean b) throws Exception {
        System.out.println(o);
    }
}
