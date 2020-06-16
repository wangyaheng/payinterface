package netty.dubbo.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultFuture {
    // 请求id
    private long id;
    // 请求id对应的响应结果
    private volatile Response response;
    // 将存储响应结果和自身绑定在一起
    public static final Map<Long,DefaultFuture> FUTURES = new ConcurrentHashMap<>();

    private int timeout;

    private final long timeStart = System.currentTimeMillis();

    private volatile Lock lock = new ReentrantLock();

    // 线程通知条件
    private volatile Condition condition = lock.newCondition();


    public DefaultFuture(ClientRequest clientRequest){
        id = clientRequest.getId();
        FUTURES.put(id, this);
    }

    public Response get(long to){
        long start = System.currentTimeMillis();

        lock.lock();
        while(!hasDone()){
            try {
                condition.await(to, TimeUnit.MILLISECONDS);
                if(System.currentTimeMillis()-start>=to){
                    // 获取超时
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        return response;
    }

    private boolean hasDone() {
        return response !=null? true:false;
    }

    public static void recieve(Response response){
        DefaultFuture defaultFuture = FUTURES.get(response.getId());

        if(defaultFuture==null){
            return ;
        }

        Lock lock = defaultFuture.getLock();
        lock.lock();
        try {
            Condition condition = defaultFuture.getCondition();
            defaultFuture.setResponse(response);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
