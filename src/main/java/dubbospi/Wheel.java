package dubbospi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Wheel {
    @Adaptive("wheel")
    void getWheel(URL url);
}
