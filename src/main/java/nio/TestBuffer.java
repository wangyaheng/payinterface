package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 */
public class TestBuffer {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File(""));
            FileChannel channeIn = fis.getChannel();
            FileOutputStream fos = new FileOutputStream("");
            FileChannel channelOut = fos.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);

            while(true){
                allocate.clear();
                int read = channeIn.read(allocate);
                if(-1==read)break;
                allocate.flip();
                channelOut.write(allocate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
