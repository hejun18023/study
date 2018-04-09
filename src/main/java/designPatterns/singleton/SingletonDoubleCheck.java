package designPatterns.singleton;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单例模式（双重校验，线程安全）
 * Created by za-hejun on 2018/3/23.
 */
public class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck instance;

    private static Lock lock = new ReentrantLock();

    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance(){
        if(null == instance){
            //尝试获取锁 1
            if(lock.tryLock()){
                try {
                    //再次判断是否已经实例化
                    if(null == instance){
                        instance = new SingletonDoubleCheck();
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
        return instance;
    }
}


