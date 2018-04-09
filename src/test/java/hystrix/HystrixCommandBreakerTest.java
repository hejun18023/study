package hystrix;

import com.netflix.hystrix.*;
import org.junit.Test;
import utils.ThreadUtils;

import java.util.stream.IntStream;

/**
 * Created by hejun on 2017/12/28.
 */
public class HystrixCommandBreakerTest extends HystrixCommand<String> {
    private String name;

    public HystrixCommandBreakerTest(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CircuitBreakerTestGroup"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("CircuitBreakerTestKey"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("CircuitBreakerTest"))
                        .andThreadPoolPropertiesDefaults(	// 配置线程池
                                HystrixThreadPoolProperties.Setter()
                                        .withCoreSize(200)	// 配置线程池里的线程数，设置足够多线程，以防未熔断却打满threadpool
                        )
                        .andCommandPropertiesDefaults(	// 配置熔断器
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerEnabled(true)
                                        .withCircuitBreakerRequestVolumeThreshold(3)
                                        .withCircuitBreakerErrorThresholdPercentage(50)
//                		.withCircuitBreakerForceOpen(true)	// 置为true时，所有请求都将被拒绝，直接到fallback
//                		.withCircuitBreakerForceClosed(true)	// 置为true时，将忽略错误
//                		.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)	// 信号量隔离
//                		.withExecutionTimeoutInMilliseconds(5000)
                        )
        );
        this.name = name;
    }

    @Override
    protected String getFallback(){
        System.out.println(Thread.currentThread().getName() + " name = " + name + "  call fallback.");
        return Thread.currentThread().getName() + name + "  call fallback.";
    }

    /**
     * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
     *
     * @return R response type
     * @throws Exception if command execution fails
     */
    @Override
    protected String run() throws Exception {
        String threadName = Thread.currentThread().getName() + " name = " + name;
        if(Integer.parseInt(name) % 2 == 0 && Integer.parseInt(name) < 10){
            System.out.println(threadName + "come in");
        }else{
            ThreadUtils.sleep(2000, threadName);
        }
        return "";
    }

    public static class Test{
        @org.junit.Test
        public void testBreaker(){
            IntStream.range(0, 50)
                    .forEach(i -> new HystrixCommandBreakerTest(String.valueOf(i)).execute());
        }
    }
}
