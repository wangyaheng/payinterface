package netty.netty3;

public interface Resolve {

    boolean support(MessageType messageType);

    Message resolve(Message message);
}
