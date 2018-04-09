package designPatterns.singleton;

/**
 * 饿汉模式，线程安全，在加载该类的时候便会实例化，达不到延迟加载的目的
 * Created by za-hejun on 2018/3/23.
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return instance;
    }
}
