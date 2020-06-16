package netty.netty3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * 数据编码
 */
public class MessageEncode extends MessageToByteEncoder<Message>{

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        if(!message.getMessageType().equals(MessageType.EMPTY)){
            // 将msg写入到byteBuf中
            byteBuf.writeInt(C.MAGIC_NUM);// 魔数
            byteBuf.writeByte(C.MAIN_VERSION);
            byteBuf.writeByte(C.SUB_VERSION);
            byteBuf.writeByte(C.MODIFY_VERSION);
            byteBuf.writeBytes(genSessionId().getBytes());

            // 写入消息类型
            byteBuf.writeByte(message.getMessageType().getType());
            byteBuf.writeShort(message.getAttachments().size());	// 写入当前消息的附加参数数量
            message.getAttachments().forEach((key, value) -> {
                Charset charset = Charset.defaultCharset();
                byteBuf.writeInt(key.length());	// 写入键的长度
                byteBuf.writeCharSequence(key, charset);	// 写入键数据
                byteBuf.writeInt(value.length());	// 希尔值的长度
                byteBuf.writeCharSequence(value, charset);	// 写入值数据
            });

            if (null == message.getBody()) {
                byteBuf.writeInt(0);	// 如果消息体为空，则写入0，表示消息体长度为0
            } else {
                byteBuf.writeInt(message.getBody().length());
                byteBuf.writeCharSequence(message.getBody(), Charset.defaultCharset());
            }



        }
    }
    private String genSessionId(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (i == 0 && 8 > 1)
                str.append(new Random().nextInt(9) + 1);
            else
                str.append(new Random().nextInt(10));
        }
        return str.toString();
    }
}
