package designPatterns.strategy.calculate.impl;

import designPatterns.strategy.StrategyAnnotation;
import designPatterns.strategy.calculate.Calculate;

/**
 * Created by za-hejun on 2018/3/26.
 */
@StrategyAnnotation(max = 4999, min = 2000)
public class SuperCalculate implements Calculate {

    @Override
    public double cal(double oringin) {
        //do something for super customer, 策略模式中更强调do something
        return oringin * 0.8;
    }
}