package designPatterns.strategy;

import designPatterns.strategy.calculate.Calculate;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * 价格计算器工厂
 * Created by za-hejun on 2018/3/26.
 */
public class CalculateFactory {

    private volatile  static CalculateFactory instance;

    private static Lock lock = new ReentrantLock();

    //需要扫描的路径
    private static final String path = "designPatterns.strategy.calculate.impl";

    private List<Class<Calculate>> classes;

    private CalculateFactory(){
        try {
            classes = getSubClass(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //获取工厂实例
    public static CalculateFactory getInstance(){
        if(null == instance){
            try{
                if(lock.tryLock()){
                    if(null == instance){
                        instance = new CalculateFactory();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    //获取所有计算接口的实现类
    private List<Class<Calculate>> getSubClass(String path) throws URISyntaxException {
        File[] files = getResources(path);
        if(null == files || files.length == 0){
            return null;
        }

        return Arrays.asList(files).stream().map(file -> {
            Class clazz;
            try {
                //根据类名获取Class对象
                clazz = getClass().getClassLoader().loadClass(path + file.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                clazz = Calculate.class;
            }
            return clazz;
        }).filter(clazz ->{
            //过滤接口本身，和非实现类
            return Calculate.class.isAssignableFrom(clazz) && clazz != Calculate.class;
        }).collect(Collectors.toList());
    }

    //获取指定路径的所有class文件
    private File[] getResources(String path) throws URISyntaxException {
        String filePath = path.replaceAll(".", "/");
        File file = new File(getClass().getClassLoader().getResource(filePath).toURI());
        return file.listFiles(pathname -> {
            //过滤以.class结尾的文件
            return pathname.getName().endsWith(".class");

        });
    }

    //获取计算接口实例
    public Calculate getCaculate(final Player player){
        Optional<Calculate> calculate = classes.stream().filter(clazz ->{
            StrategyAnnotation annotation = clazz.getAnnotation(StrategyAnnotation.class);
            return player.getPrice() > annotation.min() && player.getPrice() < annotation.max();
        }).map(clazz ->{
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).findFirst();
        return calculate.get();
    }
}
