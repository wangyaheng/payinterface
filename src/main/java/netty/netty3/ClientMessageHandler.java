package netty.netty3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ClientMessageHandler extends ServerMessageHandler{

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        executor.execute(new MessageSender(ctx));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                // 一定时间内，当前服务没有发生读取事件，也即没有消息发送到当前服务来时，
                // 其会发送一个Ping消息到服务器，以等待其响应Pong消息
                Message message = new Message();
                message.setMessageType(MessageType.PING);
                ctx.writeAndFlush(message);
            } else if (event.state() == IdleState.WRITER_IDLE) {
                // 如果当前服务在指定时间内没有写入消息到管道，则关闭当前管道
                ctx.close();
            }
        }
    }


    private static final class MessageSender implements Runnable {

        private static final AtomicLong counter = new AtomicLong(1);
        private volatile ChannelHandlerContext ctx;

        public MessageSender(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // 模拟随机发送消息的过程
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    Message message = new Message();
                    message.setMessageType(MessageType.REQUEST);
                    message.setBody("this is my " + counter.getAndIncrement() + " message.");
                    Map<String,String> map = new HashMap<>();
                    map.put("name", "xufeng");
                    message.setAttachments(map);
                    ctx.writeAndFlush(message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
