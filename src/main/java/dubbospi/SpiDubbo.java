package dubbospi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpiDubbo {

    public static void main(String[] args) throws IOException {
        Car adaptiveExtension = ExtensionLoader.getExtensionLoader(Car.class).getExtension("red");

        Map<String,String> paramMap = new HashMap<String, String>();
        paramMap.put("wheel","red");
        URL url = new URL("","",1,paramMap);
        adaptiveExtension.makeCar(url);

        System.in.read();

    }
}
