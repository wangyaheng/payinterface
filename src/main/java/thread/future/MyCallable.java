package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable<String> implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("mycallcble");
        TimeUnit.SECONDS.sleep(2);
        return "hello callable";
    }
}
