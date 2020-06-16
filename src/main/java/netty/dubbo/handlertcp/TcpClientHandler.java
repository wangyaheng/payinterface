package netty.dubbo.handlertcp;

import com.alibaba.fastjson.JSONObject;
import com.lefu.commons.utils.lang.JsonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.dubbo.bean.DefaultFuture;
import netty.dubbo.bean.Response;

/**
 * 客户端读取数据的handler
 */
public class TcpClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 是否是心跳信息
       if("ping".equals(msg.toString())){
           ctx.channel().writeAndFlush("ping\r\n");
           return ;
       }

        System.out.println("接收到服务端消息："+ msg.toString());
        String str = getJSONObject(msg.toString()).toString();
        Response res = JSONObject.parseObject(str, Response.class);

        DefaultFuture.recieve(res);
    }

    private JSONObject getJSONObject(String str){
        JSONObject json = JSONObject.parseObject(str);
        json.remove("content");
        json.put("msg","保存用户信息成功");
        return json;
    }

}
