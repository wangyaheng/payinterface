package netty.netty3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Server {

    public static void main(String[] args) {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup workeres = new NioEventLoopGroup();// 默认cpu核心数*2


        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,workeres)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 处理拆包粘包
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(1024,0,4,0,4));
                            pipeline.addLast(new LengthFieldPrepender(4));
                            // 自定义编码解码器
                            pipeline.addLast(new MessageEncode());
                            pipeline.addLast(new MessageDecode());
                            // 处理消息
                            pipeline.addLast(new ServerMessageHandler());

                        }
                    });

            ChannelFuture sync = bootstrap.bind(8989).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
