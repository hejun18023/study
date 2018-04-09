package utils;

/**
 * Created by hejun on 2017/12/28.
 */
public class ThreadUtils {

    public static void sleep(int time, String name) throws Exception {
        System.out.println(name + " sleeping " + time + "ms");
        Thread.sleep(2000);
        System.out.println(name + "finished sleeping. ");
    }
}
