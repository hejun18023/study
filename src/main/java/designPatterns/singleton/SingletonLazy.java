package designPatterns.singleton;

/**
 * 懒汉模式，线程不安全
 * Created by za-hejun on 2018/3/23.
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(null == instance){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
