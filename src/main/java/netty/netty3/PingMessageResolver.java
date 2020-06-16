package netty.netty3;

public class PingMessageResolver implements Resolve {
 
  @Override
  public boolean support(MessageType message) {
    return message == MessageType.PING;
  }
 
  @Override
  public Message resolve(Message message) {
    // 接收到ping消息后，返回一个pong消息返回
    System.out.println("receive ping message: " + System.currentTimeMillis());
    Message pong = new Message();
    pong.setMessageType(MessageType.PONG);
    return pong;
  }
}
