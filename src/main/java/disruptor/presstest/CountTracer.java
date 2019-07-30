package disruptor.presstest;

public interface CountTracer {

    void start();

    boolean count();

    void end();

    void waitForReach() throws InterruptedException;
}
