package netty.netty3;

public class PongMessageResolver implements Resolve {
 
  @Override
  public boolean support(MessageType message) {
    return message == MessageType.PONG;
  }
 
  @Override
  public Message resolve(Message message) {
    // 接收到pong消息后，不需要进行处理，直接返回一个空的message
    System.out.println("receive pong message: " + System.currentTimeMillis());
    Message empty = new Message();
    empty.setMessageType(MessageType.EMPTY);
    return empty;
  }
}