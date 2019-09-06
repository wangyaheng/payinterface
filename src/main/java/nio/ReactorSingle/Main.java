package nio.ReactorSingle;
      
import java.io.IOException;
      
public class Main {
      
          
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            TcpReactor reactor = new TcpReactor(1333);
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}