package nio.ReactorSingle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TcpReactor implements Runnable{

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;


    public TcpReactor(int port) throws IOException {
        selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress(port);
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(addr);
        serverSocketChannel.configureBlocking(false);// 设置为非阻塞
        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);// 将serverSocketChannel注册到多路选择器上
        register.attach(new Acceptor(selector,serverSocketChannel));// 给这个读事件的key注册一个Acceptor对象

    }
    @Override
    public void run() {
        while(!Thread.interrupted()){
            System.out.println("wait for accept connect :"+serverSocketChannel.socket().getLocalPort());

            try {
                if(selector.select()==0){
                    // 没有时间准备就绪
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();// 获得已经就绪的事件
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while(iterator.hasNext()){
                    dispatch(iterator.next());
                    iterator.remove();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * name: dispatch(SelectionKey key)
     * description: 調度方法，根據事件綁定的對象開新線程
     */
    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) (key.attachment()); // 根據事件之key綁定的對象開新線程
        if (r != null)
            r.run();
    }
}
