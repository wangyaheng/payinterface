package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class MyHytrixCommand extends HystrixCommand<String>{

    private HelloService helloService;

    public MyHytrixCommand(HelloService helloService) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)////至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)//信号量隔离
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(10)));//最大并发请求量

        this.helloService = helloService;

    }

    @Override
    protected String run() throws Exception {
        System.out.println(this.circuitBreaker.isOpen());
        return helloService.sayHello();
    }
    @Override
    protected String getFallback() {
        return "system error";
    }


}
