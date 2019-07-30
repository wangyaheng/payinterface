package dubbospi;

import org.apache.dubbo.common.URL;

public class RedCar implements Car{

    private Wheel wheel;

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void makeCar(URL url) {
        wheel.getWheel(url);
        System.out.println("red car method");

    }
}
