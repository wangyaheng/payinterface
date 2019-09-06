package nio.ReactorSingle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class TCPHandler implements Runnable{
    private final SelectionKey selectionKey;
    private final SocketChannel accept;

    public TCPHandler(SelectionKey selectionKey, SocketChannel accept) {
        this.selectionKey = selectionKey;
        this.accept = accept;
    }

    @Override
    public void run() {
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private synchronized void read() throws IOException {
        // non-blocking下不可用Readers，因為Readers不支援non-blocking
        byte[] arr = new byte[1024];
        ByteBuffer buf = ByteBuffer.wrap(arr);

        int numBytes = accept.read(buf); // 讀取字符串
        if(numBytes == -1)
        {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
            return;
        }
        String str = new String(arr); // 將讀取到的byte內容轉為字符串型態
        if ((str != null) && !str.equals(" ")) {
            process(str); // 邏輯處理
            System.out.println(accept.socket().getRemoteSocketAddress().toString()
                    + " > " + str);

            selectionKey.interestOps(SelectionKey.OP_WRITE); // 通過key改變通道註冊的事件
            // 使一個阻塞住的selector操作立即返回
            accept.write(ByteBuffer.wrap("hello".getBytes()));
            selectionKey.selector().wakeup();

        }
    }
    private void closeChannel() {
        try {
            selectionKey.cancel();
            accept.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    void process(String str) {
        // do process(decode, logically process, encode)..
        // ..
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
