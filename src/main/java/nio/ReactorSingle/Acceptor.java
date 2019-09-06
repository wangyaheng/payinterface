package nio.ReactorSingle;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 处理NIO链接事件
 */
public class Acceptor implements Runnable{

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;


    public Acceptor(Selector selector, ServerSocketChannel serverSocketChannel) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            SocketChannel accept = serverSocketChannel.accept();
            accept.configureBlocking(false);
            System.out.println(accept.socket().getRemoteSocketAddress().toString() + " is connected.");
            if(accept!=null){
                SelectionKey register = accept.register(selector, SelectionKey.OP_READ);// 给SocketChannel注册一个Read事件
               // selector.wakeup();
                register.attach(new TCPHandler(register, accept));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
