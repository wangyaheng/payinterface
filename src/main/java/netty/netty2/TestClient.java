package netty.netty2;


import io.netty.bootstrap.Bootstrap;

import io.netty.channel.ChannelFuture;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class TestClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new TestClientInitializer());
        ChannelFuture connect = bootstrap.connect("127.0.0.1", 8989).sync();
        System.out.println(connect.isSuccess());
      // connect.channel().writeAndFlush("hello");

        System.out.println("================");
        connect.channel().closeFuture().sync();

    }
}
