package hystrix;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hejun on 2017/12/27.
 */
public class HystrixCommandQueueTest {
    @Test
    public void testQueue() throws ExecutionException, InterruptedException, TimeoutException {
        Future<String> future = new HelloHystrixCommand("hj").queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("啊哈");
        String msg = future.get(20000, TimeUnit.MILLISECONDS);
        System.out.println("over");
        System.out.println(msg);
    }
}
