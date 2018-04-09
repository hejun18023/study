package designPatterns.singleton;

/**
 * 懒汉模式，线程安全，直接锁方法，性能非常低
 * Created by za-hejun on 2018/3/23.
 */
public class SingletonLazySave {
    private static SingletonLazySave instance;

    private SingletonLazySave(){}

    public synchronized static SingletonLazySave getInstance(){
        if(null == instance){
            instance = new SingletonLazySave();
        }
        return instance;
    }
}
