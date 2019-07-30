package disruptor.presstest;
public class TestEvent{
    private Integer i;



    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "TestEvent{" +
                "i=" + i +
                '}';
    }
}
