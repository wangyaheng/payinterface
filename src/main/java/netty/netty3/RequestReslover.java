package netty.netty3;

import java.util.HashMap;
import java.util.Map;

public class RequestReslover implements Resolve{
    @Override
    public boolean support(MessageType messageType) {
        return MessageType.REQUEST.equals(messageType);
    }

    @Override
    public Message resolve(Message message) {
        System.out.println("收到message"+message);

        Message response = new Message();
        response.setMessageType(MessageType.RESPONSE);
        response.setBody("nice to meet you too!");
        Map<String,String> map = new HashMap<>();
        map.put("name", "xufeng");
        map.put("hometown", "wuhan");
        response.setAttachments(map);

        return response;
    }
}
