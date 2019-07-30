package disruptor.presstest;


public interface EventPublisher {
    void publish(int data) throws InterruptedException;

    void start();
}
