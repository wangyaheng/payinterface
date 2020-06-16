package netty.netty3;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Message解码
 */
public class MessageDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decoded = this.decode(channelHandlerContext, byteBuf);
        if (decoded != null) {
            list.add(decoded);
        }
    }

    private Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf){
        Message message = new Message();
        message.setMagicNum(byteBuf.readInt());  // 读取魔数
        message.setMainVersion(byteBuf.readByte()); // 读取主版本号
        message.setSubVersion(byteBuf.readByte()); // 读取次版本号
        message.setModifyVersion(byteBuf.readByte());	// 读取修订版本号
        CharSequence sessionId = byteBuf.readCharSequence(
                8, Charset.defaultCharset());	// 读取sessionId
        message.setSessionId((String)sessionId);

        message.setMessageType(MessageType.get(byteBuf.readByte()));	// 读取当前的消息类型
        short attachmentSize = byteBuf.readShort();	// 读取附件长度
        Map<String, String> attachments  = new HashMap<>();
        for (short i = 0; i < attachmentSize; i++) {
            int keyLength = byteBuf.readInt();	// 读取键长度和数据
            CharSequence key = byteBuf.readCharSequence(keyLength, Charset.defaultCharset());
            int valueLength = byteBuf.readInt();	// 读取值长度和数据
            CharSequence value = byteBuf.readCharSequence(valueLength, Charset.defaultCharset());
            attachments.put(key.toString(), value.toString());

        }
        message.setAttachments(attachments);
        int bodyLength = byteBuf.readInt();	// 读取消息体长度和数据
        CharSequence body = byteBuf.readCharSequence(bodyLength, Charset.defaultCharset());
        message.setBody(body.toString());


        return message;
    }
}
