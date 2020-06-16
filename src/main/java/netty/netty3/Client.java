package netty.netty3;

import com.alibaba.rocketmq.common.message.MessageDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;


public class Client {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventLoopGroup)
                    .option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            // 添加用于解决粘包和拆包问题的处理器
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                            pipeline.addLast(new LengthFieldPrepender(4));
                            // 添加用于进行心跳检测的处理器
                            pipeline.addLast(new IdleStateHandler(1, 2, 0));
                            // 添加用于根据自定义协议将消息与字节流进行相互转换的处理器
                            pipeline.addLast(new MessageEncode());
                            pipeline.addLast(new MessageDecode());
                            // 添加客户端消息处理器
                            pipeline.addLast(new ClientMessageHandler());

                        }
                    });
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8989).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
