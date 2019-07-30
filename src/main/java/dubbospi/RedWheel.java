package dubbospi;

import org.apache.dubbo.common.URL;

public class RedWheel implements Wheel{
    @Override
    public void getWheel(URL url) {
        System.out.println("red wheel");
    }
}
