package designPatterns.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单重校验，线程不安全
 * Created by za-hejun on 2018/3/23.
 */
public class SingletonOnceCheck {
    private static volatile SingletonOnceCheck instance;
    private static Lock lock = new ReentrantLock();

    private SingletonOnceCheck(){}

    public static SingletonOnceCheck getInstance(){
        if(null == instance){
            //尝试获取锁 1
            if(lock.tryLock()){
                try {
                    instance = new SingletonOnceCheck();
                }finally {
                    lock.unlock();
                }
            }
        }
        return instance;
    }
}
