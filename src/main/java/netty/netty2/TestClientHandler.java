package netty.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

public class TestClientHandler extends SimpleChannelInboundHandler<String> {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "来自客户端的问候";
        System.out.println(str.getBytes("GBK").length);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        ctx.channel().close();
    }

    //读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress()+",client output"+s);
        channelHandlerContext.writeAndFlush("form client"+ LocalDateTime.now());
    }


    //通道就绪
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i=0;i<10;i++){
            System.out.println("channelActive");
            ctx.writeAndFlush("来自客户端的问候");
        }
       /* System.out.println("hello world");
       byte[] b = "hello world".getBytes();
       ByteBuf buffer = Unpooled.buffer(b.length);
       buffer.writeBytes(b);
       ctx.writeAndFlush(buffer);*/


    }

    //有异常发生
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
