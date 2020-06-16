package netty.netty3;

public class ResponseReslover implements Resolve{
    @Override
    public boolean support(MessageType messageType) {
        return MessageType.RESPONSE.equals(messageType);
    }

    @Override
    public Message resolve(Message message) {
        System.out.println("收到响应信息"+message);
        Message empty = new Message();
        empty.setMessageType(MessageType.EMPTY);
        return empty;
    }
}
