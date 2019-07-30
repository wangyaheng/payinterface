package disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 *将收到的消息转化为MessageEvent
 */
public class MessageEventTranlator implements EventTranslatorOneArg<MessageEvent,String>{
    @Override
    public void translateTo(MessageEvent messageEvent, long l, String s) {
        messageEvent.setMessage(s);
    }
}
