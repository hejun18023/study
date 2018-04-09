package designPatterns.strategy.calculate.impl;

import designPatterns.strategy.StrategyAnnotation;
import designPatterns.strategy.calculate.Calculate;

/**
 * 普通计算方式
 * Created by za-hejun on 2018/3/26.
 */
@StrategyAnnotation(max = 999, min = 1)
public class CommonCalculate implements Calculate {
    public double cal(double oringin){
        return oringin;
    }
}
