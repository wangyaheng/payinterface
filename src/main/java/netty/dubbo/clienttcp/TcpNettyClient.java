package netty.dubbo.clienttcp;

import com.lefu.commons.utils.lang.JsonUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.dubbo.bean.ClientRequest;
import netty.dubbo.bean.DefaultFuture;
import netty.dubbo.bean.Response;
import netty.dubbo.bean.User;
import netty.dubbo.initialzertcp.TcpClientInitalizer;
import netty.netty3.Client;
import org.junit.runner.RunWith;

/**
 * netty客户端
 */
public class TcpNettyClient {

    static EventLoopGroup group =null;
    static Bootstrap client =null;
    public static ChannelFuture future=null;
    static {
        group = new NioEventLoopGroup();
        client = new Bootstrap();
        client.group(group);
        client.channel(NioSocketChannel.class);
        client.option(ChannelOption.SO_KEEPALIVE,true);
        client.handler(new TcpClientInitalizer());
        try {
            future = client.connect("localhost", 8080).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //发送数据的方法
    public static Object send(ClientRequest request){
        try{
            System.out.println("客户端向服务端发送请求数据:"+ JsonUtils.toJsonString(request));
            //客户端直接发送请求数据到服务端
            future.channel().writeAndFlush(JsonUtils.toJsonString(request));
            //根据\r\n进行换行
            future.channel().writeAndFlush("\r\n");
            //通过请求实例化请求和响应之间的关系
            DefaultFuture defaultFuture = new DefaultFuture(request);
            //通过请求ID，获取对应的响应处理结果
            Response response = defaultFuture.get(10000);
            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            new Thread(new UserRequestThread(i)).start();//模拟多线程并发请求
        }

    }

    static class UserRequestThread implements Runnable{
        private int requestid;

        public UserRequestThread(int requestid){
            this.requestid = requestid;
        }

        @Override
        public void run() {
            synchronized (UserRequestThread.class){
                ClientRequest request = new ClientRequest();
                request.setCommand("saveUser");
                User user= new User();
                user.setAge(1);
                user.setUserName("tom");
                request.setContent(user);
                Object send = TcpNettyClient.send(request);
                System.out.println("客户端长连接返回："+ send);
            }
        }
    }


}
