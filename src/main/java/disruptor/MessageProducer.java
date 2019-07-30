package disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class MessageProducer {

    private RingBuffer<MessageEvent> rb;

    public MessageProducer(RingBuffer<MessageEvent> rb){
        this.rb=rb;
    }

    public void onData(String message){
        EventTranslatorOneArg<MessageEvent,String> translator = new MessageEventTranlator();
        rb.publishEvent(translator,message);
    }
}
