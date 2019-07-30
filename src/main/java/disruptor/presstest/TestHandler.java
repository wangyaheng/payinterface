package disruptor.presstest;

public class TestHandler implements MsgHandler{

    private CountTracer countTracer;

    public TestHandler(CountTracer countTracer){
        this.countTracer = countTracer;
        countTracer.start();
    }
    @Override
    public boolean handle() {

        boolean count = countTracer.count();
        return count;
    }
}
