package netty.netty2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;



public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        /**
         * 1) lengthFieldOffset  //长度字段的偏差
         * 2) lengthFieldLength  //长度字段占的字节数
         * 3) lengthAdjustment  //添加到长度字段的补偿值
         * 4) initialBytesToStrip  //从解码帧中第一次去除的字节数
         *
         * 第一个参数为1024，表示数据包的最大长度为1024；第二个参数0，表示长度域的偏移量为0，也就是长度域放在了最前面，处于包的起始位置；
         * 第三个参数为4，表示长度域占用4个字节；第四个参数为0，表示长度域保存的值，仅仅为有效数据长度，不包含其他域（如长度域）的长度；
         * 第五个参数为4，表示最终的取到的目标数据包，抛弃最前面的4个字节数据，长度域的值被抛弃。
         */

        //ChannelInboundHandlerAdapter
        // LengthFieldBasedFrameDecoder(单个包最大长度，数据长度字节段开始的偏移量，数据长度字段所需要的字节数，，从整个包第一个字节开始向后忽略的字节数)
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,2,0,2));
        //ChannelOutboundHandlerAdapter
        pipeline.addLast(new LengthFieldPrepender(4)); //计算当前待发送消息的二进制字节长度，将该长度添加到ByteBuf的缓冲区头中
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8)); //ChannelInboundHandlerAdapter
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));//ChannelOutboundHandlerAdapter
        pipeline.addLast(new TestServerHandler());//SimpleChannelInboundHandler
    }
}
