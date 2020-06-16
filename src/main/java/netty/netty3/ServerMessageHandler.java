package netty.netty3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerMessageHandler extends SimpleChannelInboundHandler<Message>{

    private MessageResolverFactory factory = MessageResolverFactory.getInstance();
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {
        Resolve resolve = factory.getResolve(message.getMessageType());
        Message result = resolve.resolve(message);
        channelHandlerContext.writeAndFlush(result);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered......");
        factory.registResolve(new RequestReslover());
        factory.registResolve(new ResponseReslover());
        factory.registResolve(new PingMessageResolver());
        factory.registResolve(new PongMessageResolver());
    }
}
