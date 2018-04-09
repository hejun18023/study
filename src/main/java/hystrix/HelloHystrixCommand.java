package hystrix;

import com.netflix.hystrix.*;

/**
 * Created by hejun on 2017/12/27.
 */
public class HelloHystrixCommand extends HystrixCommand<String> {

    private String name;

    public HelloHystrixCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("testCommandGroupKey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("testThreadPool"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(50000)));
        this.name = name;
    }

    private void sleep() throws Exception {
        int i = 0;
        while(i < 4){
            Thread.sleep(2000);
            System.out.println("sleep" + i);
            i ++;

        }
    }

    /**
     * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
     *
     * @return R response type
     * @throws Exception if command execution fails
     */
    @Override
    protected String run() throws Exception {
        System.out.println("start to excute Hystrix command.");
        sleep();
        return "hello " + name + ", welcome to Hystrix!";
    }
}
